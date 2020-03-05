package com.example.newsapplication.screen.newsfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.databinding.ListItemNewsBinding
import com.example.newsapplication.model.Result
import kotlinx.coroutines.newSingleThreadContext

class Adapter(var context: Context, var newArrayList: ArrayList<Result>, private val clickListerner:(result:Result)-> Unit): RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder(var binding: ListItemNewsBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item:Result, clickListerner: (result: Result) -> Unit){
            binding.news = item
            binding.root.setOnClickListener {
                clickListerner(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ListItemNewsBinding.inflate(view)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return newArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(newArrayList[position], clickListerner)

}