package com.example.myapplication.repository

import com.example.myapplication.model.Product

interface Repository {
    fun addProduct(product: Product)
    fun deleteProduct(id:String, cantidad:Int)
    fun searchProduct(productList: MutableList<Product>, newText: String?): List<Product>
}