package com.example.workshopapp.domain.login

sealed class LoginResult {

    object Loading : LoginResult()

    object Success : LoginResult()

    sealed class Error : LoginResult() {

        object UserName : Error()

        object Password : Error()
    }
}