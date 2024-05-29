package com.example.myapplication.repository

import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory

interface Repository {
    fun getProducts(): List<Product>
    fun addProduct(product: Product)
    fun updateProduct(product: Product)

    fun removeProductAt(position: Int)
    fun searchProduct(productList: List<Product>, newText: String?): List<Product>
}