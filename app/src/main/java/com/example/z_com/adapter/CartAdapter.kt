//package com.example.z_com.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.LinearLayout
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.z_com.R
//import com.example.z_com.models.Menus
//
//class CartAdapter(val menuList: List<Menus?>?) :
//    RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.MyViewHolder {
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.cart_list_row, parent, false)
//        return MyViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CartAdapter.MyViewHolder, position: Int) {
//        holder.bind(menuList?.get(position)!!)
//    }
//
//    override fun getItemCount(): Int {
//        return if (menuList == null) return 0 else menuList.size
//    }
//
//    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var thumbImage: ImageView = view.findViewById(R.id.thumbImage)
//        var menuName: TextView = view.findViewById(R.id.menuName)
//        var menuPrice: TextView = view.findViewById(R.id.menuPrice)
//        var menuQty: TextView = view.findViewById(R.id.menuQty)
//
//        fun bind(menus: Menus) {
//            menuName.text = menus?.name
//            menuPrice.text = "Price : ${menus?.price}"
//            menuQty.text = "Qty : ${menus?.totalInCart}"
//            Glide.with(thumbImage)
//                .load(menus?.url)
//                .into(thumbImage)
//        }
//    }
//
//}
package com.example.z_com.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.z_com.R
import com.example.z_com.models.Menus

class CartAdapter(val menuList: List<Menus?>?) :
    RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartAdapter.MyViewHolder, position: Int) {
        holder.bind(menuList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (menuList == null) return 0 else menuList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var thumbImage: ImageView = view.findViewById(R.id.thumbImage)
        var menuName: TextView = view.findViewById(R.id.menuName)
        var menuPrice: TextView = view.findViewById(R.id.menuPrice)
        var menuQty: TextView = view.findViewById(R.id.menuQty)

        fun bind(menus: Menus) {
            menuName.text = menus?.name
            menuPrice.text = "Price : ${menus?.price}"
            menuQty.text = "Qty : ${menus?.totalInCart}"
            Glide.with(thumbImage)
                .load(menus?.url)
                .into(thumbImage)
        }
    }

}