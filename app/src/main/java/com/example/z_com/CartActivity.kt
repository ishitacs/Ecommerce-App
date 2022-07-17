package com.example.z_com

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.z_com.adapter.CartAdapter
import com.example.z_com.models.ProductListModel


class CartActivity : AppCompatActivity() {
private var cartAdapter: CartAdapter? = null
private val rvItem: RecyclerView
    get() = findViewById(R.id.cartItemsRecyclerView)
    private val tvSubtotalAmount: TextView
        get() = findViewById(R.id.tvSubtotalAmount)
    private val tvTotalAmount: TextView
        get() = findViewById(R.id.tvTotalAmount)
    private val buttonPlaceYourOrder: TextView
        get() = findViewById(R.id.buttonPlaceYourOrder)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val productListModel = intent?.getParcelableExtra<ProductListModel>("ProductListModel")
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        buttonPlaceYourOrder.setOnClickListener {
            Toast.makeText(this@CartActivity, "Order Placed", Toast.LENGTH_LONG).show()
//            var i: Intent = Intent(applicationContext, ItemsActivity::class.java)
//            startActivity(i)
            finish()
        }
        initRecyclerView(productListModel)
        calculateTotalAmount(productListModel)
    }
    private fun initRecyclerView(productListModel: ProductListModel?) {
        rvItem.layoutManager = LinearLayoutManager(this)
        cartAdapter = CartAdapter(productListModel?.menus)
        rvItem.adapter = cartAdapter
    }
        private fun calculateTotalAmount(productListModel: ProductListModel?) {
        var subTotalAmount = 0f
        for (menu in productListModel?.menus!!) {
            subTotalAmount =  subTotalAmount + menu?.price?.times(menu?.totalInCart!!)!!
        }
        tvSubtotalAmount.text = "Rs." + String.format("%.2f", subTotalAmount)
        tvTotalAmount.text = "Rs." + String.format("%.2f", subTotalAmount)
    }

}




