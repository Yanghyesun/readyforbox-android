package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.Product
import com.choidaye.readyforbox.R

class PackageRecyclcerViewAdapter(val ctx: Context, val packageList: ArrayList<Product>) : RecyclerView.Adapter<PackageRecyclcerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_package_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = packageList.size


    override fun onBindViewHolder(holer: Holder, position: Int) {
        Glide.with(ctx)
            .load(packageList[position].main_img)
            .into(holer.main_img)
        holer.price.text=packageList[position].price.toString()
        holer.saled_price.text = packageList[position].saled_price.toString()
        holer.content.text = packageList[position].content


    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val price: TextView = itemView.findViewById(R.id.tv_fg_package_list_original_cost) as TextView
        val main_img : ImageView = itemView.findViewById(R.id.iv_item_fg_package_list) as ImageView
        val saled_price : TextView = itemView.findViewById(R.id.tv_fg_package_list_saled_price)as TextView
        val content : TextView = itemView.findViewById(R.id.tv_fg_package_list_content) as TextView


    }

}