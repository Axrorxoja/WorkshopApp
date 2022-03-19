package com.example.workshopapp.workshop3.global

sealed class LoginIntent {
    data class Login(val userName: String, val password: String) : LoginIntent()
    object ForgotPassword : LoginIntent()
    object CreateAccount : LoginIntent()
}