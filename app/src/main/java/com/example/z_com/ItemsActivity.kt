package com.example.z_com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.z_com.Session.LoginPref
import com.example.z_com.adapter.ItemAdapter
import com.example.z_com.models.Menus
import com.example.z_com.models.ProductListModel
import com.google.gson.Gson
import java.io.*
import java.lang.Exception

class ItemsActivity : AppCompatActivity(), ItemAdapter.MenuListClickListener {
    private var itemInCartList: MutableList<Menus?>? = null
    private var totalItemInCart = 0
    private var menusList: List<Menus?>? = null
    private var itemAdapter: ItemAdapter? = null
    private val checkoutButton: TextView
        get() = findViewById(R.id.checkoutButton)
    private val rvItem: RecyclerView
        get() = findViewById(R.id.rvItem)
    private var session: LoginPref? = null
    private var user: HashMap<String, String>? = null
    lateinit var productList: List<ProductListModel?>
    private lateinit var productListModel: ProductListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        productList = getProductsData()
        productListModel = productList[0]!!
        session = LoginPref(this)
//        session?.checkLogin()
        if (session?.isLoggedIn() == true) {
            session?.checkLogin()
            user = session?.getUserDetails()
        }
        user?.get(LoginPref.KEY_USERNAME)?.let { Log.d("emaill", it) }
        menusList = productListModel.menus

        initRv(menusList)
//add a method
        if (session?.isLoggedIn() == false) {
            checkoutButton.isActivated = false
        }
        checkoutButton.setOnClickListener {
            handleCartItem()
        }

    }

    private fun initRv(menus: List<Menus?>?) {
        rvItem.layoutManager = GridLayoutManager(this, 2)
        itemAdapter = ItemAdapter(menus, this)
        rvItem.adapter = itemAdapter
    }

    private fun getProductsData(): List<ProductListModel?> {
        val inputStream: InputStream = resources.openRawResource(R.raw.product_list)
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        } catch (e: Exception) {
        }
        val jsonStr: String = writer.toString()
        val gson = Gson()
        //directly pass list
        return gson.fromJson(jsonStr, Array<ProductListModel>::class.java)
            .toList()
    }

    override fun addToCartListener(menu: Menus) {
        if (itemInCartList == null) {
            itemInCartList = ArrayList()
        }
        itemInCartList?.add(menu)
        totalItemInCart = 0
        for (menu in itemInCartList!!) {
            totalItemInCart = totalItemInCart + menu?.totalInCart!!
        }
        checkoutButton.text = "Checkout (" + totalItemInCart + ") Items"
    }

    override fun updateCartListener(menu: Menus) {
        val index = itemInCartList!!.indexOf(menu)
        itemInCartList?.removeAt(index)
        itemInCartList?.add(menu)
        totalItemInCart = 0
        for (menu in itemInCartList!!) {
            totalItemInCart = totalItemInCart + menu?.totalInCart!!
        }
        checkoutButton.text = "Checkout (" + totalItemInCart + ") Items"
    }

    override fun removeCartListener(menu: Menus) {
        if (itemInCartList!!.contains(menu)) {
            itemInCartList?.remove(menu)
            totalItemInCart = 0
            for (menu in itemInCartList!!) {
                totalItemInCart = totalItemInCart + menu?.totalInCart!!
            }
            checkoutButton.text = "Checkout (" + totalItemInCart + ") Items"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 && requestCode == RESULT_OK) {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val indicator: MenuItem? = menu?.findItem(R.id.nav_log)
        val logout: MenuItem? = menu?.findItem(R.id.nav_logout)
        val profile: MenuItem? = menu?.findItem(R.id.nav_profile)
        val loginGuest: MenuItem? = menu?.findItem(R.id.nav_login)
        if (session?.isLoggedIn() == true) {
            indicator?.title = user?.get(LoginPref.KEY_USERNAME)
            indicator?.isEnabled = false
            loginGuest?.isVisible = false
        } else {
            indicator?.isVisible= false
            logout?.isVisible = false
            //cart?.isEnabled = false
            profile?.isVisible = false
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_cart -> handleCartItem()
            R.id.nav_login -> session?.LogoutUser()
            R.id.nav_logout -> session?.LogoutUser()
            R.id.nav_profile -> Toast.makeText(this, "Logged in as ${user?.get(LoginPref.KEY_USERNAME)}", Toast.LENGTH_LONG)
                .show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun handleCartItem() {
        if (totalItemInCart==0) {
            Toast.makeText(this@ItemsActivity, "Add some items", Toast.LENGTH_LONG).show()
        } else if (session?.isLoggedIn() == false) {
            Toast.makeText(this@ItemsActivity, "Log in to move to cart", Toast.LENGTH_LONG).show()
        } else {
            productListModel?.menus = itemInCartList
            val intent = Intent(this@ItemsActivity, CartActivity::class.java)
            intent.putExtra("ProductListModel", productListModel)
            startActivityForResult(intent, 1000)
        }
    }
    //itemInCartList != null && itemInCartList!!.size <= 0 &&
    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }


}
