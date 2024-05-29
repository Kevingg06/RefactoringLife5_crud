package com.example.myapplication.ui.ui.add

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentAddBinding;
import com.example.myapplication.model.Product;
import com.example.myapplication.ui.ProductViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val id = binding.idEditText.text.toString().trim()
            val name = binding.nameEditText.text.toString().trim()
            val priceText = binding.priceEditText.text.toString().trim()
            val image = binding.imageEditText.text.toString().trim()
            val stockText = binding.stockEditText.text.toString().trim()

            if (id.isEmpty()) {
                binding.idEditText.error = "Se requiere el ID del producto"
                return@setOnClickListener
            }

            if (name.isEmpty()) {
                binding.nameEditText.error = "Se requiere el nombre del producto"
                return@setOnClickListener
            }

            if (priceText.isEmpty()) {
                binding.priceEditText.error = "Se requiere el precio del producto"
                return@setOnClickListener
            }

            val price = try {
                priceText.toDouble()
            } catch (e: NumberFormatException) {
                binding.priceEditText.error = "El precio debe ser un número decimal"
                return@setOnClickListener
            }

            if (image.isEmpty()) {
                binding.imageEditText.error = "Se requiere la URL de la imagen"
                return@setOnClickListener
            }

            if (stockText.isEmpty()) {
                binding.stockEditText.error = "Se requiere el stock del producto"
                return@setOnClickListener
            }

            val stock = try {
                stockText.toInt()
            } catch (e: NumberFormatException) {
                binding.stockEditText.error = "El stock debe ser un número"
                return@setOnClickListener
            }

            val product = Product(id, name, price, image, stock)
            viewModel.addProduct(product)

            // Mensaje de alerta
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Producto añadido")
                .setMessage("El producto se ha agregado exitosamente.")
                .setPositiveButton("Aceptar") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()

            // Limpiar campos
            binding.idEditText.text?.clear()
            binding.nameEditText.text?.clear()
            binding.priceEditText.text?.clear()
            binding.imageEditText.text?.clear()
            binding.stockEditText.text?.clear()
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}