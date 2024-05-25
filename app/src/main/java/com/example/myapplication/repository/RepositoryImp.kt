package com.example.myapplication.repository

import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory
import com.example.myapplication.utils.Inventory.products

class RepositoryImp() : Repository {
    override fun addProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: String, cantidad: Int) {
        for (item in products) {
            if (id == item.id) {
                item.stock = item.stock - cantidad
            }
        }
    }

    override fun searchProduct(id: String):Product? {
        for (product in products) {
            if (product.id == id) {
                    return product
                }
            }
        return null
        }
}