package com.example.uangkass

import android.app.Application
import android.util.Log

class App : Application() {

    companion object {
        var db : DatabaseHelper? = null
    }

    override fun onCreate() {
        super.onCreate()

        db = DatabaseHelper(this)
        Log.e("_LogApp", "Hallo")
    }
}