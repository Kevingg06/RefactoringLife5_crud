package com.example.myapplication.utils

import com.example.myapplication.model.Product

object Inventory {
    val products = mutableListOf<Product>().apply {
        add(Product("01", "Redmi Note 13", 1.629, "https://http2.mlstatic.com/D_NQ_NP_945367-MLA74927641613_032024-O.webp", 5))
        add(Product("02", "MacBook Air M2", 4.450, "https://http2.mlstatic.com/D_NQ_NP_999100-MLA73526838187_122023-O.webp", 10))
        add(Product("03", "iPad Mini", 2.199, "https://http2.mlstatic.com/D_NQ_NP_958029-MPE52024486412_102022-O.webp", 15))
        add(Product("04", "CPU Gamer", 1.609, "https://http2.mlstatic.com/D_NQ_NP_709349-MLU75151902671_032024-O.webp", 4))
    }
}