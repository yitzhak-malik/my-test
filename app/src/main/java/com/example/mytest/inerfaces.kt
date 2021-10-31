package com.example.mytest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

interface TransactionInterface{

   open fun transaction(fragment: Fragment, id: Int, function: (() -> FragmentTransaction?)?) {
        var transaction: FragmentTransaction? = null
       if (function != null) {
           function().also { transaction = it }
       }
        if (transaction != null) {
            transaction!!.addToBackStack("myPlaceFragment")
            transaction!!.replace(id, fragment)
            transaction!!.commit()
        }
    }
}