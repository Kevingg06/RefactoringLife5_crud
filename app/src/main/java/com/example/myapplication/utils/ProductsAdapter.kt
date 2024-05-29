package com.example.myapplication.utils

import com.example.myapplication.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemHomeBinding
import com.example.myapplication.model.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(
    private var productList: MutableList<Product>,
    private val onActionClick: (String, String) -> Unit
) : RecyclerView.Adapter<ProductsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.myapplication.R.layout.item_home, parent, false)
        return ProductsHolder(view, onActionClick)
    }

    fun setNewList(newList: List<Product>) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        holder.render(productList[position])
    }
}

class ProductsHolder(view: View, private val onActionClick: (String, String) -> Unit) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHomeBinding.bind(view)

    fun render(value: Product) {
        binding.productId.text = value.id
        binding.productName.text = "Nombre: ${value.name}"
        binding.productPrice.text = "Precio: $${value.price}"
        binding.productStock.text = "Stock: ${value.stock}"
        Picasso.get().load(value.image).into(binding.productImage)

        binding.updateButton.setOnClickListener {
            onActionClick(value.id, "edit")
        }

        binding.deleteButton.setOnClickListener {
            onActionClick(value.id, "delete")
        }
    }
}