package com.example.myapplication.ui.ui.add

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.FragmentAddBinding;
import com.example.myapplication.model.Product;
import com.example.myapplication.ui.ProductViewModel


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
            val id = binding.idEditText.text.toString()
            val name = binding.nameEditText.text.toString()
            val image = binding.imageEditText.text.toString()
            val stock = binding.stockEditText.text.toString().toInt()
            val product = Product(id, name, image, stock)
            viewModel.addProduct(product)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}