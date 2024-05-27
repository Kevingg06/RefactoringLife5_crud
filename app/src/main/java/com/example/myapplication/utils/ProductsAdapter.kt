package com.example.myapplication.utils
import com.example.myapplication.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemHomeBinding
import com.example.myapplication.model.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(private var productList: List<Product>) : RecyclerView.Adapter<ProductsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ProductsHolder(view)
    }

    fun setFilteredList(filteredList: List<Product>){
        productList = filteredList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        holder.render(productList[position])
    }
}

class ProductsHolder(view: View) : RecyclerView.ViewHolder(view){

    private val binding = ItemHomeBinding.bind(view)

    fun render(value : Product){
        binding.productId.text = value.id
        binding.productName.text = value.name
        binding.productStock.text = value.stock.toString()
        Picasso.get().load(value.image).into(binding.productImage)
    }
}