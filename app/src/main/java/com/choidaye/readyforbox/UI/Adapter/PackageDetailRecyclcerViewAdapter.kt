package com.choidaye.readyforbox.UI.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.choidaye.readyforbox.Data.PackageDetail
import com.choidaye.readyforbox.R

class PackageDetailRecyclcerViewAdapter(val ctx: Context, val packageDetailList: ArrayList<PackageDetail>) : RecyclerView.Adapter<PackageDetailRecyclcerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_fg_package_list, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int = packageDetailList.size


    override fun onBindViewHolder(holer: Holder, position: Int) {
        Glide.with(ctx)
                .load(packageDetailList[position].detail_img)
                .into(holer.detail_img)
        holer.name.text=packageDetailList[position].name.toString()
        holer.price.text=packageDetailList[position].price.toString()
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detail_img : ImageView = itemView.findViewById(R.id.iv_item_package_detail) as ImageView
        val name : TextView = itemView.findViewById(R.id.txt_item_package_name)as TextView
        val price: TextView = itemView.findViewById(R.id.txt_item_package_price) as TextView
    }

}