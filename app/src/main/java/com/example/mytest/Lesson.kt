package com.example.mytest

import android.content.Context
import java.io.Serializable

class Lesson(val courseName:String,val title: String, val Subtitle: String, val Description: String, val stars: Int) :
    Serializable {
public var imageRes = 0
}
