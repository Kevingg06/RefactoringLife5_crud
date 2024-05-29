package com.example.myapplication.ui.ui.delete

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentDeleteBinding
import com.example.myapplication.model.Product
import com.example.myapplication.ui.ProductViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DeleteFragment : Fragment() {

    private var _binding: FragmentDeleteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by activityViewModels()
    private val args: DeleteFragmentArgs by navArgs()
    private lateinit var product: Product

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product = viewModel.products.value?.find { it.id == args.productId } ?: return

        binding.productId.text = product.id
        binding.productName.text = "Nombre: ${product.name}"
        binding.productPrice.text = "Precio: $${product.price}"
        binding.productStock.text = "Stock: ${product.stock}"
        binding.productImage.setImageURI(Uri.parse(product.image))

        binding.deleteButton.setOnClickListener {
            viewModel.deleteProduct(product.id)
            showAlertDialog("Éxito", "Producto eliminado correctamente")
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun showAlertDialog(title: String, message: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { _, _ ->
                findNavController().navigateUp()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}