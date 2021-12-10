package com.example.lifecyclesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }

    public override fun onStart() {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onStart()
    }

    public override fun onRestart() {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onRestart()
    }

    public override fun onResume() {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onResume()
    }

    public override fun onPause() {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onPause()
    }

    public override fun onStop() {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onStop()
    }

    public override fun onDestroy() {
        Log.i("LifeCycleSample", "Sub onCreate() called.")
        super.onDestroy()
    }

    fun onButtonClick(view: View) {
        finish()
    }
}