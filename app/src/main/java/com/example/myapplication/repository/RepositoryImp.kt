package com.example.myapplication.repository
import com.example.myapplication.model.Product
import com.example.myapplication.utils.Inventory
import com.example.myapplication.utils.Inventory.products

class RepositoryImp() : Repository {

    override fun getProducts(): List<Product> {
        return Inventory.products
    }

    override fun addProduct(product: Product) {
        Inventory.products.add(product)
    }

    override fun deleteProduct(id: String, cantidad: Int) {
        for (item in products) {
            if (id == item.id) {
                item.stock -= cantidad
            }
        }
    }

    override fun searchProduct(id: String): Product? {
        for (product in products) {
            if (product.id == id) {
                return product
            }
        }
        return null
    }
}