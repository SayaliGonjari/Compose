package com.plcoding.navigationdrawercompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.navigationdrawercompose.model.UserDetails
import com.plcoding.navigationdrawercompose.network.APIService
import com.plcoding.navigationdrawercompose.network.Details
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _userList = mutableStateListOf<Details>()
    var errorMessage: String by mutableStateOf("")

     val userList: List<Details>
        get() = _userList

    fun userDetailsList() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()

            try {
                _userList.clear()
                _userList.addAll(apiService.getDetails())

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }


}