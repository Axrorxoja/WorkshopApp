package com.example.workshopapp.workshop2.solution

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.App
import com.example.workshopapp.domain.login.LoginInteractor
import kotlinx.coroutines.Dispatchers

class Workshop2SolutionViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        Workshop2SolutionViewModel::class.java -> Workshop2SolutionViewModel(
            interactor = LoginInteractor(dispatcher = Dispatchers.Default),
            resourceProvider = App.resourceProvider,
        )
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}