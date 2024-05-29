package com.example.myapplication.ui.ui.delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDeleteBinding
import com.example.myapplication.model.Product

class DeleteFragment : Fragment() {

    private val productList: MutableList<Product> = mutableListOf()
    private lateinit var productAdapter: DeleteProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño para este fragmento
        val view = inflater.inflate(R.layout.fragment_delete, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.listadeleteproductos)

        recyclerView.layoutManager = LinearLayoutManager(context)
        //recyclerView.adapter= DeleteProductAdapter(getProducts())
        productAdapter = DeleteProductAdapter(productList)
        recyclerView.adapter = productAdapter

        // Inicializar la lista de productos
        initializeProducts()

        return view
    //return inflater.inflate(R.layout.fragment_delete, container, false)
    }
    //private fun getProducts(): List<Product> {
    private fun initializeProducts() {
        productList.addAll(
        // Aquí puedes añadir productos reales
        //return listOf(
            listOf(
            Product("Producto 1", "Descripción 1",100.0,"https://drcormillot.com.ar/wp-content/uploads/2023/04/salchicha_1_ok.jpg",10),
            Product("Producto 2", "Descripción 2",151.0,"https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/ecaeb2cc-a950-4645-a648-9137305b3287/Derivates/df977b90-193d-49d4-a59d-8dd922bcbf65.jpg",15),
            Product("Producto 3", "Descripción 3",161.0,"https://www.cucinare.tv/wp-content/uploads/2020/11/Hamburguesas-1024x576.jpg",30),
            Product("Producto 4", "Descripción 4",111.0,"https://imagenes.20minutos.es/files/image_640_360/uploads/imagenes/2022/01/12/un-plato-de-patatas-fritas-recien-hechas.jpeg",1),
            Product("Producto 5", "Descripción 5",310.0,"https://i.blogs.es/95b0b1/como-hacer-tacos-pastor-sin-trompo-drake-bell-mexico/1366_2000.jpg",4),
            Product("Producto 6", "Descripción 6",500.0,"https://www.gastrolabweb.com/u/fotografias/m/2023/8/8/f1280x720-50878_182553_5050.jpg",4),
            Product("Producto 7", "Descripción 7",150.0,"https://www.eluniversal.com.mx/resizer/t_GfvlU7DHdeof_t5YTb50mkhCk=/1100x666/cloudfront-us-east-1.images.arcpublishing.com/eluniversal/MQU7YVLQVNEKVPQTX3Y7M62DTI.jpg",3),
            Product("Producto 8", "Descripción 8",130.0,"https://weelicious.com/wp-content/uploads/2021/05/Mexican-Enchiladas-2-1.jpg",10),
            Product("Producto 9", "Descripción 9",120.0,"https://thefoodtech.com/wp-content/uploads/2024/02/tamales-828x548.jpg",60),
            Product("Producto 10", "Descripción 10",30.0,"https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/76245CFF-9CA1-49B7-844C-2776FAA5A1A0/Derivates/EB37A5A4-FBCB-45C7-B8A2-7E87667439A8.jpg",30),
            Product("Producto 11", "Descripción 11",05.0,"https://assets.epicurious.com/photos/62c4b089bfd689c61cf0ac8c/1:1/w_1600,c_limit/Chilaquiles_RECIPE_062922_36571.jpg",20),
            Product("Producto 12", "Descripción 12",10.50,"https://cdn7.kiwilimon.com/recetaimagen/14881/640x426/7199.jpg.webp",5)
        )
        )
        productAdapter.notifyDataSetChanged()
    }

}
