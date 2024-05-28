package com.example.myapplication.ui.ui.delete
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeleteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Delete Fragment"
    }
    val text: LiveData<String> = _text
}
