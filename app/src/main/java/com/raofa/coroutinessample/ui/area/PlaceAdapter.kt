package com.raofa.coroutinessample.ui.area

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.raofa.coroutinessample.R
import com.raofa.coroutinessample.data.model.place.Place
import com.raofa.coroutinessample.databinding.SimpleItemBinding

/**
 * @author: fa.rao@sunyard.com
 * @date: 2020/11/02 15:22
 * @description:
 */
class PlaceAdapter(private val dataList : ArrayList<Place>) :
    RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    class PlaceViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val bind : SimpleItemBinding? =  DataBindingUtil.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_item,parent,false)
        var viewHolder =  PlaceViewHolder(view)
        viewHolder.itemView.setOnClickListener { 
            var place = dataList[viewHolder.adapterPosition]
            
        }
        
        return viewHolder
    }
    

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind?.place = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}