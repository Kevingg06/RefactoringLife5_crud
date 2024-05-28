package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.RepositoryImp
import com.example.myapplication.model.Product

class ProductViewModel(private val repositoryImp: RepositoryImp = RepositoryImp()) : ViewModel() {

    fun getProducts(): List<Product> {
        return repositoryImp.getProducts()
    }

    fun addProduct(product: Product) {
        repositoryImp.addProduct(product)
    }

    fun updateProduct(product: Product) {
        repositoryImp.updateProduct(product)
    }

    fun deleteProduct(productId: String) {
        repositoryImp.deleteProduct(productId)
    }

    fun searchProducts(query: String?): List<Product> {
        return if (query.isNullOrEmpty()) {
            getProducts()
        } else {
            getProducts().filter {
                it.name.contains(query, true) || it.id.contains(query, true)
            }
        }
    }

}
