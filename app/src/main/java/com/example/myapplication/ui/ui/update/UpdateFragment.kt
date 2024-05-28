package com.example.myapplication.ui.ui.update

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.activityViewModels;
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentUpdateBinding;
import com.example.myapplication.model.Product;
import com.example.myapplication.ui.ProductViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

class UpdateFragment : Fragment() {

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by activityViewModels()
    private val args: UpdateFragmentArgs by navArgs()
    private lateinit var product: Product

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product = viewModel.getProducts().find { it.id == args.productId } ?: return

        binding.idUpdateText.setText(product.id)
        binding.nameUpdateText.setText(product.name)
        binding.imageUpdateText.setText(product.image)
        binding.stockUpdateText.setText(product.stock.toString())
        binding.priceUpdateText.setText(product.price.toString())

        binding.updateButton.setOnClickListener {
            val name = binding.nameUpdateText.text.toString()
            val image = binding.imageUpdateText.text.toString()
            val stock = binding.stockUpdateText.text.toString().toIntOrNull() ?: 0
            val price = binding.priceUpdateText.text.toString().toDoubleOrNull() ?: 0.0

            if (name.isBlank() || image.isBlank()) {
                showAlertDialog("Error", "Todos los campos son obligatorios")
                return@setOnClickListener
            }

            product.name = name
            product.image = image
            product.stock = stock
            product.price = price
            viewModel.updateProduct(product)
            showAlertDialog("Éxito", "Producto actualizado correctamente")
        }
    }

    private fun showAlertDialog(title: String, message: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

