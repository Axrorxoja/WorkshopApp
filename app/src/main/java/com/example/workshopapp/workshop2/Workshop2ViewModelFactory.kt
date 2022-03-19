package com.example.workshopapp.workshop2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.App
import com.example.workshopapp.domain.login.LoginInteractor
import com.example.workshopapp.workshop2.solution.Workshop2SolutionViewModel
import kotlinx.coroutines.Dispatchers

class Workshop2ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        Workshop2ViewModel::class.java -> Workshop2ViewModel(
            interactor = LoginInteractor(dispatcher = Dispatchers.Default),
            resourceProvider = App.resourceProvider,
        )
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}