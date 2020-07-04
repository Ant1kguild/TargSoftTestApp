package com.app.targsoft.test.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.app.targsoft.test.databinding.FragmentHomeBinding
import com.app.targsoft.test.presentation.adapter.CatAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val catAdapter: CatAdapter by lazy {
        CatAdapter(
            { viewModel.addCatToFavorite(it) },
            { Log.e("HomeFragment", "Url to load: $it") }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.rvCats.adapter = catAdapter

        viewModel.streamResult.observe(viewLifecycleOwner, Observer {
            catAdapter.submitData(lifecycle, it)
        })

        viewModel.toastText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }
}