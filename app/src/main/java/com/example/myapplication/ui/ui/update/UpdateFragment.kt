import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.activityViewModels;
import com.example.myapplication.databinding.FragmentUpdateBinding;
import com.example.myapplication.model.Product;
import com.example.myapplication.ui.ProductViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

class EditFragment : Fragment() {

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.updateButton.setOnClickListener {
            val id = binding.idUpdateText.text.toString()
            val name = binding.nameUpdateText.text.toString()
            val image = binding.imageUpdateText.text.toString()
            val stock = binding.stockUpdateText.text.toString()
            val price = binding.priceUpdateText.text.toString()

            if (id.isEmpty() || name.isEmpty() || image.isEmpty() || stock.isEmpty() || price.isEmpty()) {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Error")
                    .setMessage("Todos los campos deben estar llenos")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                val product = Product(id, name, price.toDouble(), image, stock.toInt())
                viewModel.updateProduct(product)
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Éxito")
                    .setMessage("Producto actualizado correctamente")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}