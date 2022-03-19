package com.example.workshopapp.domain.resource

import android.content.res.Resources

class ResourceProvider(
    private val resources: Resources,
) : IResourceProvider {

    override fun string(id: Int):String {
        return resources.getString(id)
    }
}