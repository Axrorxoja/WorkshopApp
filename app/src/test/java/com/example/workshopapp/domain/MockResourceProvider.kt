package com.example.workshopapp.domain

import com.example.workshopapp.domain.resource.IResourceProvider

const val ERROR_MESSAGE = "ERROR MESSAGE"
class MockResourceProvider : IResourceProvider {
    override fun string(id: Int) = ERROR_MESSAGE
}