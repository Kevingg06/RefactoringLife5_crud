package com.example.myapplication.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.utils.Inventory.products
import com.example.myapplication.utils.ProductsAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var adapter = ProductsAdapter(products)

    private val binding get() = _binding!!

    val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.initProductList()
        initRecyclerView()
        observe()
        miSearch()

        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun miSearch() {
        binding.homeSv.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                homeViewModel.searchProducts(newText)
                return true
            }
        })
    }

    private fun observe() {
        homeViewModel.filteredProducts.observe(viewLifecycleOwner, Observer { filteredList ->
            adapter.setNewList(filteredList.toMutableList())
        })
    }

    private fun initRecyclerView() {
        binding.recyclerViewHome.adapter = adapter
    }
}
