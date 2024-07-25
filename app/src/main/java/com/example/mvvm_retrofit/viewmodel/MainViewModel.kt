package com.example.mvvm_retrofit.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit.model.UserItem
import com.example.mvvm_retrofit.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = UserRepository()
    private val _users = MutableLiveData<List<UserItem>>()
    val users : LiveData<List<UserItem>> get() = _users

    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val call = repository.getUsers()

            call.enqueue(object : Callback<List<UserItem>> {
                override fun onResponse(
                    call: Call<List<UserItem>>,
                    response: Response<List<UserItem>>
                ) {
                    if(response.isSuccessful)
                    {
                        _users.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<UserItem>>, t: Throwable) {

                    Toast.makeText(getApplication(),"Error while retrieve data ${t.message}",Toast.LENGTH_SHORT).show()
                }

            })
        }
    }


}