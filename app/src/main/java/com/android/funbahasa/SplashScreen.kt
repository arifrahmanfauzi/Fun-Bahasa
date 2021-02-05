package com.android.funbahasa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.android.funbahasa.ui.login.MainActivity

class SplashScreen : AppCompatActivity() {

    private var splashDelay : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    private fun initView() {
        Handler().postDelayed({startActivity(Intent(this, MainActivity::class.java))
        finish()
        },splashDelay)
    }

}