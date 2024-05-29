package com.example.myapplication.repository

import android.content.Context
import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory.products
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class RepositoryImp(private val context: Context) : Repository {
    private val sharedPreferences = context.getSharedPreferences("products_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()
    private val productType = object : TypeToken<MutableList<Product>>() {}.type

    private var products: MutableList<Product> = loadProducts()
    private fun loadProducts(): MutableList<Product> {
        val productsJson = sharedPreferences.getString("products", null)
        return if (productsJson != null) {
            gson.fromJson(productsJson, productType)
        } else {
            mutableListOf(
                Product("01", "Redmi Note 13", 1.629, "https://http2.mlstatic.com/D_NQ_NP_945367-MLA74927641613_032024-O.webp", 5),
                Product("02", "MacBook Air M2", 4.450, "https://http2.mlstatic.com/D_NQ_NP_999100-MLA73526838187_122023-O.webp", 10),
                Product("03", "iPad Mini", 2.199, "https://http2.mlstatic.com/D_NQ_NP_958029-MPE52024486412_102022-O.webp", 15),
                Product("04", "CPU Gamer", 1.609, "https://http2.mlstatic.com/D_NQ_NP_709349-MLU75151902671_032024-O.webp", 4)
            )
        }
    }

    private fun saveProducts() {
        val productsJson = gson.toJson(products)
        sharedPreferences.edit().putString("products", productsJson).apply()
    }

    override fun getProducts(): List<Product> {
        return products
    }

    override fun addProduct(product: Product) {
        products.add(product)
        saveProducts()
    }

    override fun updateProduct(product: Product) {
        val index = products.indexOfFirst { it.id == product.id }
        if (index != -1) {
            products[index] = product
            saveProducts()
        }
    }

    override fun deleteProduct(productId: String) {
        products.removeAll { it.id == productId }
        saveProducts()
    }

    override fun searchProduct(productList: MutableList<Product>, newText: String?): List<Product> {
        val filteredList = mutableListOf<Product>()

        if (newText.isNullOrBlank()) {
            filteredList.addAll(productList)
        } else {
            productList.forEach {
                if (it.id.lowercase().contains(newText.lowercase())) {
                    filteredList.add(it)
                }
            }
        }
        return filteredList
    }

}
