package com.example.myapplication.ui.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Product
import com.example.myapplication.repository.RepositoryImp

class HomeViewModel(private val repositoryImp: RepositoryImp = RepositoryImp()) : ViewModel() {

    private val _filteredProducts = MutableLiveData<List<Product>>()
    val filteredProducts : LiveData<List<Product>> = _filteredProducts

    fun initProductList(){
        _filteredProducts.value = repositoryImp.getProducts()
    }

    fun searchProducts(newText : String?){
        val filteredList = repositoryImp.searchProduct(repositoryImp.getProducts(), newText)
        _filteredProducts.value = filteredList

    }
}
