package com.example.workshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.workshopapp.workshop1.Workshop1Fragment
import com.example.workshopapp.workshop2.Workshop2Fragment
import com.example.workshopapp.workshop3.Workshop3Fragment
import com.example.workshopapp.workshop3.solution.Workshop3SolutionFragment

class MainActivity : AppCompatActivity(), Router {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            openFragment(SelectWorkshopFragment.newInstance(), addToBackStack = false)
        }
    }

    override fun openWorkshop1() = openFragment(Workshop1Fragment.newInstance())

    override fun openWorkshop2() = openFragment(Workshop2Fragment.newInstance())

    override fun openWorkshop3() = openFragment(Workshop3SolutionFragment.newInstance())

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(fragment::class.java.name)
        }

        transaction.commit()
    }
}