package com.example.myapplication.ui.ui.delete
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Product
import com.squareup.picasso.Picasso

class DeleteProductAdapter(private val productList: MutableList<Product>) :
    RecyclerView.Adapter<DeleteProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_delproduct, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.idTextView.text = product.id
        holder.nameTextView.text = product.name
        holder.stockTextView.text = product.stock.toString()
        holder.priceTextView.text = product.price.toString()

        // Cargar la imagen usando Picasso
        Picasso.get().load(product.image).into(holder.imageView)

        holder.deleteIcon.setOnClickListener {
            removeProductAt(position)
        }
    }
     override fun getItemCount() = productList.size

        private fun removeProductAt(position: Int) {
            productList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, productList.size)
        }

        class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val idTextView: TextView = itemView.findViewById(R.id.product_id)
            val nameTextView: TextView = itemView.findViewById(R.id.product_name)
            val stockTextView: TextView = itemView.findViewById(R.id.product_stock)
            val priceTextView: TextView = itemView.findViewById(R.id.product_price)
            val imageView: ImageView = itemView.findViewById(R.id.image_product)
            val deleteIcon: ImageView = itemView.findViewById(R.id.product_eliminar)

        }
    }

