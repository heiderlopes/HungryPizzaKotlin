package com.example.logonpf.hungrypizza

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        carregar()
    }

    private fun carregar() {
        val animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacao_splash);
        ivLogoSplash.setAnimation(animation);
        ivLogoSplash.startAnimation(animation);

        Handler().postDelayed({
            val intent = Intent(this,
                    LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this.finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}
