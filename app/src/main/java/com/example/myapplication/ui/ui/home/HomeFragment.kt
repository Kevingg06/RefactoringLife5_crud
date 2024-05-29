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

//class HomeFragment : Fragment() {

//    private var _binding: FragmentHomeBinding? = null
//    private var adapter = ProductsAdapter(products)
//
//    private val binding get() = _binding!!
//
//    val homeViewModel by viewModels<HomeViewModel>()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        miSearch()
//        initRecyclerView()
//
//        return root
//
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        adapter = ProductsAdapter(viewModel.products)
//        binding.recyclerViewHome.layoutManager = LinearLayoutManager(context)
//        binding.recyclerViewHome.adapter = adapter
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    private fun miSearch() {
//        binding.homeSv.setOnQueryTextListener(object :
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                val filteredList = homeViewModel.searchProducts(newText)
//                adapter.setNewList(filteredList)
//                return true
//            }
//        })
//    }
//
//    private fun initRecyclerView() {
//        binding.recyclerViewHome.adapter = adapter
//    }
//
//    override fun onItemClick(product: Product, action: String) {
//        when (action) {
//            "edit" -> {
//                val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(product.id)
//                findNavController().navigate(action)
//            }
//            "delete" -> {
//                viewModel.deleteProduct(product.id)
//                adapter.setNewList(viewModel.products)
//            }
//        }
//    }
//
//



//    private var _binding: FragmentHomeBinding? = null
//    private val binding get() = _binding!!
//    private val viewModel: ProductViewModel by activityViewModels()
//
//    private lateinit var adapter: ProductsAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        initRecyclerView()
//        setupSearchView()
//
//    }
//
//    private fun initRecyclerView() {
//        adapter = ProductsAdapter(
//            productList = viewModel.getProducts().toMutableList(),
//            onEdit = { product: Product ->
//                val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(product.id)
//                findNavController().navigate(action)
//            },
//            onDelete = { product: Product ->
//                viewModel.deleteProduct(product.id)
//                adapter.setNewList(viewModel.getProducts().toMutableList())
//            },
//        )
//        binding.recyclerViewHome.adapter = adapter
//    }
//
//    private fun setupSearchView() {
//        binding.homeSv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                val filteredList: List<Product> = viewModel.searchProducts(newText)
//                adapter.setNewList(filteredList.toMutableList())
//                return true
//            }
//        })
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}


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


//class HomeFragment : Fragment() {
//
//    private var _binding: FragmentHomeBinding? = null
//    private val binding get() = _binding!!
//    private val viewModel: ProductViewModel by activityViewModels()
//    private lateinit var adapter: ProductsAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        adapter = ProductsAdapter(viewModel.products.value ?: mutableListOf()) { productId, action ->
//            when (action) {
//                "edit" -> {
//                    val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(productId)
//                    findNavController().navigate(action)
//                }
//                "delete" -> {
//                    val action = HomeFragmentDirections.actionHomeFragmentToDeleteFragment(productId)
//                    findNavController().navigate(action)
//                }
//            }
//        }
//
//        binding.recyclerViewHome.adapter = adapter
//
//        viewModel.products.observe(viewLifecycleOwner) {
//            adapter.setNewList(it)
//        }
//
//        binding.homeSv.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                val filteredList = viewModel.searchProducts(newText)
//                adapter.setNewList(filteredList)
//                return true
//            }
//        })
//
//        binding.fabAddProduct.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}