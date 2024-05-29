package com.example.myapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.RepositoryImp
import com.example.myapplication.model.Product

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences = application.getSharedPreferences("products", Application.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    private val _products = MutableLiveData<MutableList<Product>>()
    val products: MutableLiveData<MutableList<Product>> get() = _products

    init {
        loadProducts()
    }

    private fun loadProducts() {
        val savedProducts = sharedPreferences.getStringSet("productSet", setOf()) ?: setOf()
        val productList = savedProducts.map { stringToProduct(it) }.toMutableList()
        _products.value = productList
    }

    private fun saveProducts() {
        val productSet = _products.value?.map { productToString(it) }?.toSet() ?: setOf()
        editor.putStringSet("productSet", productSet).apply()
    }

    fun addProduct(product: Product) {
        _products.value?.add(product)
        _products.value = _products.value
        saveProducts()
    }

    fun updateProduct(product: Product) {
        _products.value = _products.value?.map { if (it.id == product.id) product else it }?.toMutableList()
        saveProducts()
    }

    fun deleteProduct(id: String) {
        _products.value = _products.value?.filter { it.id != id }?.toMutableList()
        saveProducts()
    }

    fun searchProducts(query: String?): List<Product> {
        return if (query.isNullOrBlank()) {
            _products.value ?: emptyList()
        } else {
            _products.value?.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.id.contains(query, ignoreCase = true)
            } ?: emptyList()
        }
    }

    private fun productToString(product: Product): String {
        return "${product.id}|${product.name}|${product.price}|${product.image}|${product.stock}"
    }

    private fun stringToProduct(string: String): Product {
        val parts = string.split("|")
        return Product(parts[0], parts[1], parts[2].toDouble(), parts[3], parts[4].toInt())
    }
}
