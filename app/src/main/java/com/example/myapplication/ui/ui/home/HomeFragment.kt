package com.example.myapplication.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Product
import com.example.myapplication.repository.RepositoryImp
import com.example.myapplication.utils.Inventory.products
import com.example.myapplication.utils.ProductsAdapter

class HomeFragment(val repositoryImp: RepositoryImp = RepositoryImp()) : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var adapter = ProductsAdapter(products)

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        miSearch(products)
        initRecyclerView()

        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun miSearch(productList: MutableList<Product>) {
        binding.homeSv.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = repositoryImp.searchProduct(productList, newText)
                adapter.setFilteredList(filteredList)
                return true
            }
        })
    }

    private fun initRecyclerView() {
        binding.recyclerViewHome.adapter = adapter
    }
}