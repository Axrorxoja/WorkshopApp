package com.example.workshopapp.workshop3.solution

data class LoginViewState(
    val isLoading: Boolean = false,
    val userNameError: String? = null,
    val passwordError: String? = null,
    val success: Boolean = false
)
