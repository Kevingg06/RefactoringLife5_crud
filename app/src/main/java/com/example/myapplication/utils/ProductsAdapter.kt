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

//class ProductsAdapter(
//    private var productList: MutableList<Product>,
//    private val itemClickListener: AdapterView.OnItemClickListener
//) : RecyclerView.Adapter<ProductsHolder>() {
//
//    interface OnItemClickListener {
//        fun onItemClick(product: Product, action: String)
//    }
//
//    inner class ProductViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.updateButton.setOnClickListener {
//                itemClickListener.onItemClick(productList[adapterPosition], "Actualizar")
//            }
////            binding.deleteButton.setOnClickListener {
////                itemClickListener.onItemClick(productList[adapterPosition], "Eliminar")
////            }
//            binding.addButton.setOnClickListener {
//                itemClickListener.onItemClick(productList[adapterPosition], "Agregar")
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
//        return ProductsHolder(view)
//    }
//
//    fun setNewList(newList: List<Product>) {
//        productList.clear()
//        productList.addAll(newList)
//        notifyDataSetChanged()
//    }
//
//
//    override fun getItemCount(): Int {
//        return productList.size
//    }
//
//    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
//        holder.render(productList[position])
//    }
//}
//
//class ProductsHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//    private val binding = ItemHomeBinding.bind(view)
//
//    fun render(value: Product) {
//        binding.productId.text = value.id
//        binding.productName.text = "Nombre: ${value.name}"
//        binding.productPrice.text = "Precio: $${value.price}"
//        binding.productStock.text = "Stock: ${value.stock}"
//        Picasso.get().load(value.image).into(binding.productImage)
//    }
//}

//    private var productList: MutableList<Product>,
//    private val onEdit: (Product) -> Unit,
//    private val onDelete: (Product) -> Unit,
//) : RecyclerView.Adapter<ProductsAdapter.ProductsHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
//        return ProductsHolder(view, onEdit, onDelete)
//    }
//
//    fun setNewList(newList: MutableList<Product>) {
//        productList.clear()
//        productList.addAll(newList)
//        notifyDataSetChanged()
//    }
//
//    override fun getItemCount(): Int = productList.size
//
//    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
//        holder.render(productList[position])
//    }
//
//    class ProductsHolder(
//        view: View,
//        private val onEdit: (Product) -> Unit,
//        private val onDelete: (Product) -> Unit,
//    ) : RecyclerView.ViewHolder(view) {
//
//        private val binding = ItemHomeBinding.bind(view)
//
//        fun render(product: Product) {
//            binding.productId.text = product.id
//            binding.productName.text = "Nombre: ${product.name}"
//            binding.productPrice.text = "Precio: $${product.price}"
//            binding.productStock.text = "Stock: ${product.stock}"
//            Picasso.get().load(product.image).into(binding.productImage)
//
//            binding.updateButton.setOnClickListener { onEdit(product) }
//            binding.deleteButton.setOnClickListener { onDelete(product) }
//        }
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
//        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ProductsHolder(binding)
//    }
//
//    override fun getItemCount(): Int = productList.size
//
//    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
//        holder.bind(productList[position], onEdit, onDelete)
//    }
//
//    fun setNewList(newList: List<Product>) {
//        productList.clear()
//        productList.addAll(newList)
//        notifyDataSetChanged()
//    }
//
//    inner class ProductsHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(
//            product: Product,
//            onEdit: (Product) -> Unit,
//            onDelete: (Product) -> Unit
//        ) {
//            binding.productId.text = product.id
//            binding.productName.text = "Nombre: ${product.name}"
//            binding.productPrice.text = "Precio: $${product.price}"
//            binding.productStock.text = "Stock: ${product.stock}"
//            Picasso.get().load(product.image).into(binding.productImage)
//
//            binding.updateButton.setOnClickListener {
//                onEdit(product)
//            }
//
//            binding.deleteButton.setOnClickListener {
//                onDelete(product)
//            }
//        }
//    }
//}
//

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