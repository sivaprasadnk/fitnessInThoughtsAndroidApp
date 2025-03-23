package dev.sivaprasadnk.fitapp.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.sivaprasadnk.fitapp.api.blogService
import kotlinx.coroutines.launch

class BlogViewModel : ViewModel() {
    private val _blogs = mutableStateOf<List<Blog>>(emptyList())
    val blogs: State<List<Blog>> = _blogs

    private val _loading = mutableStateOf(true)
    val loading: State<Boolean> = _loading

    private val _completed = mutableStateOf(false)
    val completed: State<Boolean> = _completed

    private val _error = mutableStateOf("")
    val error = _error

    init {
        fetchRecentBlogs()
    }



    fun fetchRecentBlogs(){
        viewModelScope.launch {
            try{
                val response = blogService.getRecentBlogs(3)
                if(response.isSuccessful){
                    _blogs.value= response.body()!!
                    _loading.value= false
                    _completed.value= true
                }else{
                    _loading.value=false
                    _completed.value= true
                    _error.value= "Something went wrong"
                }
            }catch (e: Exception){
                _error.value= e.message.toString()
                _loading.value= false
            }
        }
    }
}
