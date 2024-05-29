package com.example.myapplication.ui.ui.home


import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Product
import com.example.myapplication.repository.RepositoryImp

import com.example.myapplication.utils.Inventory.products

class HomeViewModel(private val repositoryImp: RepositoryImp = RepositoryImp()) : ViewModel() {

    fun searchProducts(list: MutableList<Product>,newText : String?): List<Product>{
        return repositoryImp.searchProduct(list, newText)
    }
}
