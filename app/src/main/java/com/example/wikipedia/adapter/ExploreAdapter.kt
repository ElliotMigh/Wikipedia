package com.example.wikipedia.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding
import com.google.android.material.card.MaterialCardView

class ExploreAdapter(private val data: List<ItemPost>, val itemEvents: itemEvents) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding: ItemExploreBinding

    inner class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {

            Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)

            binding.txtExploreTitle.text = itemPost.txtTitle

            binding.txtExploreSubtitle.text = itemPost.txtSubTitle

            binding.txtExploreDetail.text = itemPost.txtDetail

            //click on item
            itemView.setOnClickListener {
                itemEvents.onItemClicked(itemPost)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.bindViews(data[position])

        Log.v("testApp", position.toString())

    }

    override fun getItemCount(): Int {
        return data.size
    }


}