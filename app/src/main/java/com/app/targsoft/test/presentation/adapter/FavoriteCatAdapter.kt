package com.app.targsoft.test.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.databinding.RecyclerViewFavoriteItemBinding
import com.bumptech.glide.Glide

class FavoriteCatAdapter(
    private val onClickDeleteFavorite: (cat: FavoriteCat) -> Unit
) : RecyclerView.Adapter<FavoriteCatViewHolder>() {


    private var list: List<FavoriteCat> = emptyList()

    override fun onBindViewHolder(holder: FavoriteCatViewHolder, position: Int) {
        list[position].let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCatViewHolder =
        FavoriteCatViewHolder(
            RecyclerViewFavoriteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) { onClickDeleteFavorite(it) }



    override fun getItemCount(): Int = list.size

    fun setData(cats: List<FavoriteCat>) {
        list = cats
        notifyDataSetChanged()
    }


}


class FavoriteCatViewHolder(
    private val view: RecyclerViewFavoriteItemBinding,
    private val onClickAddFavorite: (cat: FavoriteCat) -> Unit
) : ViewHolder(view.root) {
    fun bind(cat: FavoriteCat) {
        view.ivDeleteFavorite.setOnClickListener { onClickAddFavorite(cat) }
        view.ivMain.apply {
            Glide.with(context).load(cat.url).override(1080,1080).into(this)
        }
    }
}