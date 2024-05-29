package com.example.myapplication.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Product
import com.example.myapplication.ui.ProductViewModel
import com.example.myapplication.utils.Inventory.products
import com.example.myapplication.utils.ProductsAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by activityViewModels()

    private lateinit var adapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setupSearchView()
        setupAddButton()
    }

    private fun initRecyclerView() {
        adapter = ProductsAdapter(viewModel.products.value ?: mutableListOf()) { productId, action ->
            when (action) {
                "edit" -> {
                    val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(productId)
                    findNavController().navigate(action)
                }
                "delete" -> {
                    val action = HomeFragmentDirections.actionHomeFragmentToDeleteFragment(productId)
                    findNavController().navigate(action)
                }
            }
        }
        binding.recyclerViewHome.adapter = adapter
    }

    private fun setupSearchView() {
        binding.homeSv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList: List<Product> = viewModel.searchProducts(newText)
                adapter.setNewList(filteredList.toMutableList())
                return true
            }
        })
    }

    private fun setupAddButton() {
        binding.fabAddProduct.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
