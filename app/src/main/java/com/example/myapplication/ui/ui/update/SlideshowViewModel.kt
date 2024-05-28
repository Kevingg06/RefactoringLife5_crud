<<<<<<<< HEAD:app/src/main/java/com/example/myapplication/ui/ui/delete/DeleteViewModel.kt
package com.example.myapplication.ui.ui.delete
========
package com.example.myapplication.ui.ui.update
>>>>>>>> 44b97abec212f4bc8b58aa1255e5ca8643dd5e60:app/src/main/java/com/example/myapplication/ui/ui/update/SlideshowViewModel.kt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeleteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text
}
