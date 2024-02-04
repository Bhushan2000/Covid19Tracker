package com.example.covid_19track.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.covid_19track.R

class SplashActivity : AppCompatActivity() {
    private val SLEEP_TIMER = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 1000)
        //
    }

    private inner class LogoLauncher : Thread() {
        override fun run() {
            try {
                sleep((1000 * SLEEP_TIMER).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }


}