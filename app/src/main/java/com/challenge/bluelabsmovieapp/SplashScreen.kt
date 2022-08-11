package com.challenge.bluelabsmovieapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.challenge.bluelabsmovieapp.ui.activity.ActivityMovie

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 500
    private val ANIMATION_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val animationView: LottieAnimationView = findViewById(R.id.movieImageView)
        animateSplashScreen(animationView, R.raw.hmm)
    }

    private fun animateSplashScreen(imageView: LottieAnimationView, animation: Int) {
        imageView.setAnimation(animation)
        imageView.playAnimation()
        imageView.animate()
            .alpha(1f)
            .setDuration(ANIMATION_TIME_OUT)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animator: Animator) {
                    imageView.alpha = 0f
                    changeActivity()
                }

            })

    }

    private fun changeActivity() {
        Handler().postDelayed({
            startActivity(Intent(this, ActivityMovie::class.java))
            finish()
        },SPLASH_TIME_OUT)
    }
}