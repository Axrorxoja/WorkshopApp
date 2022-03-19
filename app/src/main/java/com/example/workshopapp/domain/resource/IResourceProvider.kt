package com.example.workshopapp.domain.resource

import androidx.annotation.StringRes

interface IResourceProvider {
    fun string(@StringRes id:Int):String
}