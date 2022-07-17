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
//import com.example.z_com.models.ProductListModel
//class ProductListAdapter(val productList: List<ProductListModel?>? , val clickListener: productListClickListener) :
//    RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): ProductListAdapter.MyViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_product_list, parent, false)
//        return MyViewHolder(view)
//    }
////view check
//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//    }
//    override fun onBindViewHolder(holder: ProductListAdapter.MyViewHolder, position: Int) {
//        holder.bind(productList?.get(position))
//        holder.itemView.setOnClickListener{
//            clickListener.onItemClick(productList?.get(position))
//        }
//    }
////working of rv
//    override fun getItemCount(): Int {
//        return productList?.size ?: 0
//    }
//
//    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val thumbImage: ImageView = view.findViewById(R.id.thumbImage)
//        val productName: TextView = view.findViewById(R.id.productName)
//
//        fun bind(productListModel: ProductListModel?) {
//            productName.text = productListModel?.name
//
//            Glide.with(thumbImage)
//                .load(productListModel?.image)
//                .into(thumbImage)
//        }
//    }
//
//    interface productListClickListener {
//        fun onItemClick(productListModel: ProductListModel?)
//    }
//
//}