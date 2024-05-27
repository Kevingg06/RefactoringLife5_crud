package com.example.myapplication.repository

import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory.products
import com.example.myapplication.utils.ProductsAdapter

class RepositoryImp : Repository {


    override fun addProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: String, cantidad: Int) {
        for (item in products) {
            if (id == item.id) {
                item.stock -= cantidad
            }
        }
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

