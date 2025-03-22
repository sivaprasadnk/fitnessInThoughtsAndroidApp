package dev.sivaprasadnk.fitapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dev.sivaprasadnk.fitapp.data.Blog
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import dev.sivaprasadnk.fitapp.screens.fetchApi
import kotlinx.coroutines.launch

class BlogViewModel: ViewModel() {
    private val _blogs = mutableStateOf<List<Blog>>(emptyList())
    val blogs: State<List<Blog>> = _blogs

    private val _loading = mutableStateOf(false)
    val loading:State<Boolean> = _loading

    private  val _error = mutableStateOf("")
    val error = _error

    init {
        fetchBlogs()
    }

    private  fun fetchBlogs(){
        viewModelScope.launch {
            try {
                 val response = fetchApi()
                if(response.isSuccessful){
                    _blogs.value= response.body()!!
                    _loading.value= false
                }else{
                    _loading.value= false
                    _error.value= "Failed to load blogs"
                }

            }catch (e: Exception){
                _error.value= "Error ${e.message}"
                _loading.value= false
            }
        }
    }

}