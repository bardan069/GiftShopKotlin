package com.example.giftshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giftshop.repository.UserRepositoryImpl

sealed class LoginResult {
    object Loading : LoginResult()
    data class Success(val role: String) : LoginResult()
    data class Error(val message: String) : LoginResult()
    object Idle : LoginResult()
}

class UserViewModel : ViewModel() {

    private val repository = UserRepositoryImpl()

    private val _loginState = MutableLiveData<LoginResult>(LoginResult.Idle)
    val loginState: LiveData<LoginResult> get() = _loginState

    private val _registerState = MutableLiveData<LoginResult>(LoginResult.Idle)
    val registerState: LiveData<LoginResult> get() = _registerState

    fun login(email: String, password: String) {
        _loginState.value = LoginResult.Loading
        repository.login(email, password) { success, message ->
            if (success) {
                // Determine role based on email (adjust as needed)
                val role = if (email == "admin@gmail.com") "admin" else "user"
                _loginState.value = LoginResult.Success(role)
            } else {
                _loginState.value = LoginResult.Error(message)
            }
        }
    }

    fun register(email: String, password: String) {
        _registerState.value = LoginResult.Loading
        repository.register(email, password) { success, message, _ ->
            if (success) {
                // Assume newly registered users have "user" role
                _registerState.value = LoginResult.Success("user")
            } else {
                _registerState.value = LoginResult.Error(message)
            }
        }
    }

    fun logout() {
        repository.logout { success, _ ->
            if (success) {
                _loginState.value = LoginResult.Idle
            }
        }
    }
}
