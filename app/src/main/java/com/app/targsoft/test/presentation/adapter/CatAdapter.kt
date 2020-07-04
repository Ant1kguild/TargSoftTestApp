package com.app.targsoft.test.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.targsoft.test.data.datasource.database.model.FavoriteCat
import com.app.targsoft.test.databinding.RecyclerViewItemBinding
import com.bumptech.glide.Glide

class CatAdapter(
    private val onClickAddFavorite: (cat: FavoriteCat) -> Unit,
    private val onClickDownload: (url: String) -> Unit
) : PagingDataAdapter<FavoriteCat, CatViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<FavoriteCat>() {
            override fun areItemsTheSame(oldItem: FavoriteCat, newItem: FavoriteCat): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: FavoriteCat, newItem: FavoriteCat): Boolean =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder =
        CatViewHolder(
            RecyclerViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            { onClickAddFavorite(it) },
            { onClickDownload(it) }
        )


}


class CatViewHolder(
    private val view: RecyclerViewItemBinding,
    private val onClickAddFavorite: (cat: FavoriteCat) -> Unit,
    private val onClickDownload: (url: String) -> Unit
) : ViewHolder(view.root) {
    fun bind(cat: FavoriteCat) {
        view.ivAddFavorite.setOnClickListener { onClickAddFavorite(cat) }
        view.ivDownload.setOnClickListener { onClickDownload(cat.url) }
        view.ivMain.apply {
            Glide.with(context).load(cat.url).override(1080,1080).into(this)
        }
    }
}