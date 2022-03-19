package com.example.workshopapp.workshop3.global

data class LoginViewState(
    val isDefault: Boolean = false,
    val isLoading: Boolean = false,
    val userNameError: String? = null,
    val passwordError: String? = null,
    val success: Boolean = false
)
