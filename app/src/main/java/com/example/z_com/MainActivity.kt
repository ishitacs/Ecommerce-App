////package com.example.z_com
////
////import android.content.Intent
////import androidx.appcompat.app.AppCompatActivity
////import android.os.Bundle
////import android.widget.TextView
////import android.widget.Toast
////import androidx.appcompat.app.ActionBar
////import androidx.core.widget.doOnTextChanged
////import androidx.lifecycle.MediatorLiveData
////import androidx.lifecycle.MutableLiveData
////import androidx.recyclerview.widget.GridLayoutManager
////import androidx.recyclerview.widget.LinearLayoutManager
////import androidx.recyclerview.widget.RecyclerView
////import com.example.z_com.adapter.ProductListAdapter
////import com.example.z_com.models.ProductListModel
////import com.google.android.material.button.MaterialButton
////import com.google.android.material.resources.MaterialAttributes
////import com.google.android.material.textfield.TextInputLayout
////import com.google.gson.Gson
////import java.io.*
////import java.lang.Exception
////
////class MainActivity : AppCompatActivity(), ProductListAdapter.productListClickListener {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
////        val actionBar: ActionBar? = supportActionBar
////        actionBar?.hide()
////        val productListModel = getProductsData()
////        initRv(productListModel)
////    }
////
////
////    private fun initRv(productList: List<ProductListModel?>) {
////        val rvProductList = findViewById<RecyclerView>(R.id.ProductListRV)
////        rvProductList.layoutManager = LinearLayoutManager(this)
////        val adapter = ProductListAdapter(productList,this)
////        rvProductList.adapter = adapter //set adapter to rv
////    }
////
////    private fun getProductsData(): List<ProductListModel?> {
////        val inputStream: InputStream = resources.openRawResource(R.raw.product_list)
////        val writer: Writer = StringWriter()
////        val buffer = CharArray(1024)
////        try {
////            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
////            var n: Int
////            while (reader.read(buffer).also { n = it } != -1) {
////                writer.write(buffer, 0, n)
////            }
////        } catch (e: Exception) {
////        }
////        val jsonStr: String = writer.toString()
////        val gson = Gson()
////        val productListModel =
////            gson.fromJson<Array<ProductListModel>>(jsonStr, Array<ProductListModel>::class.java)
////                .toList()
////        //directly pass list
////        return productListModel
////    }
////
////    override fun onItemClick(productListModel: ProductListModel?) {
////        val intent = Intent(this@MainActivity, ItemsActivity::class.java)
////        intent.putExtra("ProductListModel", productListModel)
////        //pass model in another way
////        startActivity(intent)
////    }
////}
//package com.example.z_com
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.ActionBar
//import androidx.core.widget.doOnTextChanged
//import androidx.lifecycle.MediatorLiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.z_com.adapter.ProductListAdapter
//import com.example.z_com.models.ProductListModel
//import com.google.android.material.button.MaterialButton
//import com.google.android.material.resources.MaterialAttributes
//import com.google.android.material.textfield.TextInputLayout
//import com.google.gson.Gson
//import java.io.*
//import java.lang.Exception
//
//class MainActivity : AppCompatActivity(), ProductListAdapter.productListClickListener {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val actionBar: ActionBar? = supportActionBar
//        actionBar?.hide()
//        val productListModel = getProductsData()
//        initRv(productListModel)
//    }
//
//
//    private fun initRv(productList: List<ProductListModel?>) {
//        val rvProductList = findViewById<RecyclerView>(R.id.ProductListRV)
//        rvProductList.layoutManager = LinearLayoutManager(this)
//        val adapter = ProductListAdapter(productList,this)
//        rvProductList.adapter = adapter //set adapter to rv
//    }
//
//    private fun getProductsData(): List<ProductListModel?> {
//        val inputStream: InputStream = resources.openRawResource(R.raw.product_list)
//        val writer: Writer = StringWriter()
//        val buffer = CharArray(1024)
//        try {
//            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
//            var n: Int
//            while (reader.read(buffer).also { n = it } != -1) {
//                writer.write(buffer, 0, n)
//            }
//        } catch (e: Exception) {
//        }
//        val jsonStr: String = writer.toString()
//        val gson = Gson()
//        val productListModel =
//            gson.fromJson<Array<ProductListModel>>(jsonStr, Array<ProductListModel>::class.java)
//                .toList()
//        //directly pass list
//        return productListModel
//    }
//
//    override fun onItemClick(productListModel: ProductListModel?) {
//        val intent = Intent(this@MainActivity, ItemsActivity::class.java)
//        intent.putExtra("ProductListModel", productListModel)
//        //pass model in another way
//        startActivity(intent)
//    }
//}