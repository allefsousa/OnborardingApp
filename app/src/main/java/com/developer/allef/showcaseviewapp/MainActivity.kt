package com.developer.allef.showcaseviewapp

import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import android.widget.Toast
import com.developer.allef.showcaseviewapp.utils.OnboardingUtils
import com.takusemba.spotlight.OnSpotlightStateChangedListener
import com.takusemba.spotlight.OnTargetStateChangedListener
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.shape.Circle
import com.takusemba.spotlight.shape.RoundedRectangle
import com.takusemba.spotlight.target.CustomTarget
import com.takusemba.spotlight.target.SimpleTarget
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.simple_target).setOnClickListener {
            val one = findViewById<View>(R.id.one)
            val inflater = LayoutInflater.from(this)
            val firstRoot = FrameLayout(this)
            val first = inflater.inflate(R.layout.layout_target, firstRoot)
            OnboardingUtils.createAnimation(this,first,one)
        }
    }
}


