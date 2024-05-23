package com.example.myapplication.repository

import com.example.myapplication.model.Product

interface Repository {
    fun addProduct(product: Product)
    fun deleteProduct(product: Product)
    fun searchProduct(product: Product)
}