package dev.sivaprasadnk.fitapp.data

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.sivaprasadnk.fitapp.api.blogService
import kotlinx.coroutines.launch


class BlogViewModel : ViewModel() {
    private val _recentBlogs = mutableStateOf<List<Blog>>(emptyList())
    val recentBlogs: State<List<Blog>> = _recentBlogs

    private var _category = mutableStateOf("all")
    val category: State<String> = _category


    private val _allBlogs = mutableStateOf<List<Blog>>(emptyList())
    val allBlogs: State<List<Blog>> = _allBlogs

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

    fun updateCategory(value:String){
        _category.value = value
        Log.d("categoryName", category.value)
    }



    fun fetchRecentBlogs(){
        viewModelScope.launch {
            try{
                _loading.value= true

                val response = blogService.getRecentBlogs(3)
                if(response.isSuccessful){
                    _recentBlogs.value= response.body()!!
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
                _blog.value= null
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

    fun fetchAllBlogs(){
        Log.d("fetchAllBlogs", "all")

        viewModelScope.launch {
            try{
                _allBlogs.value= emptyList()
                val response = blogService.getAllBlogs()
                if(response.isSuccessful){
                    _allBlogs.value= response.body()!!
                }else{
                    _error.value= "Something went wrong"
                }
            }catch (e: Exception){
                _error.value= e.message.toString()
            }
        }
    }

    fun fetchAllBlogsForCategory(value: String){
        viewModelScope.launch {
            try{
                _allBlogs.value= emptyList()
                val response = blogService.getAllBlogsForCategory(value)
                if(response.isSuccessful){
                    _allBlogs.value= response.body()!!
                }else{
                    _error.value= "Something went wrong"
                }
            }catch (e: Exception){
                _error.value= e.message.toString()
            }
        }
    }
}
