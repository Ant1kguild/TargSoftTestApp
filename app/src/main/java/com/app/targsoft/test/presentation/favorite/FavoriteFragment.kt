package com.app.targsoft.test.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.app.targsoft.test.databinding.FragmentFavoriteBinding
import com.app.targsoft.test.presentation.adapter.FavoriteCatAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding : FragmentFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModels()
    private val favoriteCatAdapter : FavoriteCatAdapter by lazy {
        FavoriteCatAdapter{
            viewModel.deleteFavorite(it)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        binding.rvFavoriteCat.adapter = favoriteCatAdapter

        viewModel.favoriteCats.observe(viewLifecycleOwner, Observer {
            favoriteCatAdapter.setData(it)
        })

        viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }
}