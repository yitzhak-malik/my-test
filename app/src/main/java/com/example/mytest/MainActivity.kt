package com.example.mytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 const val SHARED = "shared"
const val  USER_NAME = "userName"
class MainActivity : AppCompatActivity(),TransactionInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       transaction(LoginFragment.newInstance(),R.id.main_activity) { return@transaction supportFragmentManager.beginTransaction() }


    }
}