package com.example.myapplication.repository

import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory

class RepositoryImp() : Repository {

    override fun getProducts(): List<Product> {
        return Inventory.products
    }

    override fun addProduct(product: Product) {
        Inventory.products.add(product)
    }

    override fun deleteProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun searchProduct(product: Product) {
        TODO("Not yet implemented")
    }
}