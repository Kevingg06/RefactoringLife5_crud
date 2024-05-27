package com.example.myapplication.repository

import com.example.myapplication.model.Product

interface Repository {
    fun getProducts(): List<Product>
    fun addProduct(product: Product)
    fun updateProduct(product: Product)
    fun deleteProduct(id:String, cantidad:Int)
    fun searchProduct(id: String):Product?
}