package com.example.myapplication.ui.ui.delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDeleteBinding
import com.example.myapplication.model.Product
import com.example.myapplication.repository.Repository
import com.example.myapplication.repository.RepositoryImp
import com.example.myapplication.utils.Inventory

class DeleteFragment : Fragment() {

//    private val productList: MutableList<Product> = mutableListOf()
//    private lateinit var productAdapter: DeleteProductAdapter
    private lateinit var productAdapter: DeleteProductAdapter
    private val repository = RepositoryImp()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño para este fragmento
        val view = inflater.inflate(R.layout.fragment_delete, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.listadeleteproductos)

        recyclerView.layoutManager = LinearLayoutManager(context)
        productAdapter = DeleteProductAdapter(repository)
        recyclerView.adapter = productAdapter

        return view

    }

}
