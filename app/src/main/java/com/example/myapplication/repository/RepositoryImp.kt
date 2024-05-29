package com.example.myapplication.repository

import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory
import com.example.myapplication.utils.Inventory.products


class RepositoryImp: Repository {

    override fun getProducts(): List<Product> {
        return Inventory.products
    }

    override fun addProduct(product: Product) {
        Inventory.products.add(product)
    }

    override fun updateProduct(product: Product) {
        val index = Inventory.products.indexOfFirst { it.id == product.id }
        if (index != -1) {
            Inventory.products[index] = product
        }
    }

    // Elimina un producto en una posición dada de la lista de Inventory
    override fun removeProductAt(position: Int) {
        if (position >= 0 && position < Inventory.products.size) {
            Inventory.products.removeAt(position)
        }
    }


    // Busca productos en la lista que coincidan con el texto proporcionado
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