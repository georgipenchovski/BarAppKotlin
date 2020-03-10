package com.example.barappkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.barappkotlin.R
import com.example.barappkotlin.model.BarItem
import java.util.*

class RecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private var barList: List<BarItem> = ArrayList()
    private var clickListener: ItemClickListener? = null

    fun setBars(barList: List<BarItem>) {
        this.barList = barList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val v =
            LayoutInflater.from(context).inflate(R.layout.item_bar, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val bar = barList[position]
        holder.barName.text = barList[position].name
//        holder.barDistance.text =
//            Math.round(barList[position].distance).toString() + holder.meters
        holder.cardView.setOnClickListener { clickListener!!.onItemClick(bar) }
    }

    override fun getItemCount(): Int {
        return barList.size
    }

    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var barName: TextView
        var barDistance: TextView
        var cardView: CardView
        var meters: String

        init {
            barName = itemView.findViewById(R.id.txt_bar_name)
            barDistance = itemView.findViewById(R.id.txt_bar_distance)
            cardView = itemView.findViewById(R.id.cv_item_bar)
            meters = itemView.context.resources.getString(R.string.meters)
        }
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        clickListener = itemClickListener
    }

    interface ItemClickListener {
        fun onItemClick(bar: BarItem?)
    }

}
