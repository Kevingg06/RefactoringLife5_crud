package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.RepositoryImp
import com.example.myapplication.model.Product

class ProductViewModel(private val repositoryImp: RepositoryImp = RepositoryImp()) : ViewModel() {

//    private val _products = MutableLiveData<List<Product>>()
//    val products: LiveData<List<Product>> get() = _products
//
//    init {
//        _products.value = repositoryImp.getProducts()
//    }

    fun getProducts(): List<Product> {
        return repositoryImp.getProducts()
    }

    fun addProduct(product: Product) {
        repositoryImp.addProduct(product)
//        _products.value = repositoryImp.getProducts()
    }

    fun updateProduct(product: Product) {
        repositoryImp.updateProduct(product)
    }

}
