package dev.sivaprasadnk.fitapp.data

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sivaprasadnk.fitapp.api.blogService
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BlogViewModel @Inject constructor() : ViewModel() {
    private val _blogs = mutableStateOf<List<Blog>>(emptyList())
    val blogs: State<List<Blog>> = _blogs

    private val _blog = mutableStateOf<Blog?>(null)
    val blog: State<Blog?> = _blog

    private val _loading = mutableStateOf(true)
    val loading: State<Boolean> = _loading

    private val _detailsLoading = mutableStateOf(true)
    val detailsLoading: State<Boolean> = _detailsLoading

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

    fun fetchBlogDetails(id: Int){
        viewModelScope.launch {
            try{
                _detailsLoading.value= true
                val response = blogService.getBlog(id)
                if(response.isSuccessful){
                    _blog.value= response.body()!!
                    _detailsLoading.value= false
                    _completed.value= true
                }else{
                    _detailsLoading.value=false
                    _completed.value= true
                    _error.value= "Something went wrong"
                }
            }catch (e: Exception){
                _error.value= e.message.toString()
                _detailsLoading.value= false
            }
        }
    }
}
