package com.example.myapplication.repository

import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory.products


class RepositoryImp : Repository {

    override fun getProducts(): List<Product> {
        return products
    }

    override fun addProduct(product: Product) {
        products.add(product)
    }

    override fun updateProduct(product: Product) {
        val index = products.indexOfFirst { it.id == product.id }
        if (index != -1) {
            products[index] = product
        }
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
