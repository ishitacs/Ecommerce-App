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
import com.example.z_com.models.ProductListModel

class ItemAdapter(val menuList: List<Menus?>?, val clickListener: MenuListClickListener) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.menu_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.MyViewHolder, position: Int) {
        holder.bind(menuList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return menuList?.size ?: return 0
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var thumbImage: ImageView = view.findViewById(R.id.thumbImage)
        var menuName: TextView = view.findViewById(R.id.menuName)
        var menuPrice: TextView = view.findViewById(R.id.menuPrice)
        var addToCartButton: TextView = view.findViewById(R.id.addToCartButton)
        var addMoreLayout: LinearLayout = view.findViewById(R.id.addMoreLayout)
        var imageMinus: ImageView = view.findViewById(R.id.imageMinus)
        var tvCount: TextView = view.findViewById(R.id.tvCount)
        var imageAddOne: ImageView = view.findViewById(R.id.imageAddOne)

        fun bind(menus: Menus) {
            menuName.text = menus?.name
            menuPrice.text = "Price : ${menus?.price}"
            addToCartButton.setOnClickListener {
                menus?.totalInCart = 1
                clickListener.addToCartListener(menus)
                addMoreLayout?.visibility = View.VISIBLE
                addToCartButton.visibility = View.GONE
                tvCount.text = menus?.totalInCart.toString()
            }
            imageMinus.setOnClickListener {
                var total: Int = menus?.totalInCart
                total--
                if (total > 0) {
                    menus?.totalInCart = total
                    clickListener.updateCartListener(menus)
                    tvCount.text = menus?.totalInCart.toString()
                } else {
                    menus.totalInCart = total
                    clickListener.removeCartListener(menus)
                    addMoreLayout?.visibility = View.GONE
                    addToCartButton.visibility = View.VISIBLE
                }

            }
            imageAddOne.setOnClickListener {
                var total: Int = menus?.totalInCart
                total++
                if (total <= 10) {
                    menus?.totalInCart = total
                    clickListener.updateCartListener(menus)
                    tvCount.text = total.toString()
                }
            }
            Glide.with(thumbImage)
                .load(menus?.url)
                .into(thumbImage)
        }
    }

    interface MenuListClickListener {
        fun addToCartListener(menu: Menus)
       fun updateCartListener(menu: Menus)
        fun removeCartListener(menu: Menus)
    }
}
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
//import com.example.z_com.models.ProductListModel
//
//class ItemAdapter(val menuList: List<Menus?>?, val clickListener: MenuListClickListener) :
//    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.MyViewHolder {
////        val view: View =
////            LayoutInflater.from(parent.context).inflate(R.layout.menu_list_row, parent, false)
////        return MyViewHolder(view)
////    }
////
////    override fun onBindViewHolder(holder: ItemAdapter.MyViewHolder, position: Int) {
////        holder.bind(menuList?.get(position)!!)
////    }
////
////    override fun getItemCount(): Int {
////        return menuList?.size ?: return 0
////    }
//
////    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
////        var thumbImage: ImageView = view.findViewById(R.id.thumbImage)
////        var menuName: TextView = view.findViewById(R.id.menuName)
////        var menuPrice: TextView = view.findViewById(R.id.menuPrice)
////        var addToCartButton: TextView = view.findViewById(R.id.addToCartButton)
////        var addMoreLayout: LinearLayout = view.findViewById(R.id.addMoreLayout)
////        var imageMinus: ImageView = view.findViewById(R.id.imageMinus)
////        var tvCount: TextView = view.findViewById(R.id.tvCount)
////        var imageAddOne: ImageView = view.findViewById(R.id.imageAddOne)
////
////        fun bind(menus: Menus) {
////            menuName.text = menus?.name
////            menuPrice.text = "Price : ${menus?.price}"
////            addToCartButton.setOnClickListener {
////                menus?.totalInCart = 1
////                clickListener.addToCartListener(menus)
////                addMoreLayout?.visibility = View.VISIBLE
////                addToCartButton.visibility = View.GONE
////                tvCount.text = menus?.totalInCart.toString()
////            }
////            imageMinus.setOnClickListener {
////                var total: Int = menus?.totalInCart
////                total--
////                if (total > 0) {
////                    menus?.totalInCart = total
////                    clickListener.updateCartListener(menus)
////                    tvCount.text = menus?.totalInCart.toString()
////                } else {
////                    menus.totalInCart = total
////                    clickListener.removeCartListener(menus)
////                    addMoreLayout?.visibility = View.GONE
////                    addToCartButton.visibility = View.VISIBLE
////                }
////
////            }
////            imageAddOne.setOnClickListener {
////                var total: Int = menus?.totalInCart
////                total++
////                if (total <= 10) {
////                    menus?.totalInCart = total
////                    clickListener.updateCartListener(menus)
////                    tvCount.text = total.toString()
////                }
////            }
////            Glide.with(thumbImage)
////                .load(menus?.url)
////                .into(thumbImage)
////        }
////    }
//
//    interface MenuListClickListener {
//        fun addToCartListener(menu: Menus)
//        fun updateCartListener(menu: Menus)
//        fun removeCartListener(menu: Menus)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//       val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
//        val view: View
//        if(viewType==0) {
//            view = layoutInflater.inflate(R.layout.menu_list_row, parent, false)
//            return MyViewHolder1(view)
//        }
//        else {
//            view = layoutInflater.inflate(R.layout.banner_list,parent,false)
//            return MyViewHolder(view)
//        }
//    }
//
//    override fun onBindViewHolder(holder: ItemAdapter.MyViewHolder, position: Int) {
//
//    }
//
//    override fun getItemCount(): Int {
//        return menuList?.size ?: return 0
//    }
//
//    override fun getItemViewType(position: Int): Int {
//      if (menuList?.size!! > 0 ) return 1
//        return 0
//    }
//
//    inner class MyViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
//        var banner: ImageView = view.findViewById(R.id.bannerImage)
//    }
//
//    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var thumbImage: ImageView = view.findViewById(R.id.thumbImage)
//        var menuName: TextView = view.findViewById(R.id.menuName)
//        var menuPrice: TextView = view.findViewById(R.id.menuPrice)
//        var addToCartButton: TextView = view.findViewById(R.id.addToCartButton)
//        var addMoreLayout: LinearLayout = view.findViewById(R.id.addMoreLayout)
//        var imageMinus: ImageView = view.findViewById(R.id.imageMinus)
//        var tvCount: TextView = view.findViewById(R.id.tvCount)
//        var imageAddOne: ImageView = view.findViewById(R.id.imageAddOne)
//
//        fun bind(menus: Menus) {
//            menuName.text = menus?.name
//            menuPrice.text = "Price : ${menus?.price}"
//            addToCartButton.setOnClickListener {
//                menus?.totalInCart = 1
//                clickListener.addToCartListener(menus)
//                addMoreLayout?.visibility = View.VISIBLE
//                addToCartButton.visibility = View.GONE
//                tvCount.text = menus?.totalInCart.toString()
//            }
//            imageMinus.setOnClickListener {
//                var total: Int = menus?.totalInCart
//                total--
//                if (total > 0) {
//                    menus?.totalInCart = total
//                    clickListener.updateCartListener(menus)
//                    tvCount.text = menus?.totalInCart.toString()
//                } else {
//                    menus.totalInCart = total
//                    clickListener.removeCartListener(menus)
//                    addMoreLayout?.visibility = View.GONE
//                    addToCartButton.visibility = View.VISIBLE
//                }
//
//            }
//            imageAddOne.setOnClickListener {
//                var total: Int = menus?.totalInCart
//                total++
//                if (total <= 10) {
//                    menus?.totalInCart = total
//                    clickListener.updateCartListener(menus)
//                    tvCount.text = total.toString()
//                }
//            }
//            Glide.with(thumbImage)
//                .load(menus?.url)
//                .into(thumbImage)
//        }
//    }
//}