package com.example.myapplication.repository

import com.example.myapplication.model.Product

interface Repository {
    fun getProducts(): List<Product>
    fun addProduct(product: Product)
    fun updateProduct(product: Product)
    fun deleteProduct(productId: String)
    fun searchProduct(productList: MutableList<Product>, newText: String?): List<Product>
}