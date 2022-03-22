package com.example.testlanguage

import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {
    var changeLanguage:()->Unit = {}

    fun onChangeLanguage(){
        changeLanguage()
    }
}