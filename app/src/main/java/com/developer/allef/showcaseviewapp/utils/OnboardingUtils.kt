package com.developer.allef.showcaseviewapp.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import com.developer.allef.showcaseviewapp.R
import com.takusemba.spotlight.OnSpotlightStateChangedListener
import com.takusemba.spotlight.OnTargetStateChangedListener
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.shape.RoundedRectangle
import com.takusemba.spotlight.target.CustomTarget

/**
 * @author allef.santos on 2019-10-29
 */
object OnboardingUtils {
    fun createAnimation(context: Activity,view:View,one:View){
        val oneLocation = IntArray(2)
        one.getLocationInWindow(oneLocation)
        val oneX = oneLocation[0] + one.width / 2f
        val oneY = oneLocation[1] + one.height / 2f
        val oneRadius = 100f

//            // first target
//            val firstTarget = SimpleTarget.Builder(this)
//                .setPoint(oneX, oneY)
//                .setShape(RoundedRectangle(oneY, (one.width).toFloat(), oneRadius))
//                .setTitle("first title")
//                .setDescription("first description")
//                .setOverlayPoint(100f, oneY + oneRadius + 100f)
//                .build()


        val customTarget = CustomTarget.Builder(context)
            .setPoint(oneX, oneY)
            .setShape(RoundedRectangle(oneY, (one.width).toFloat(), oneRadius))
            .setOverlay(view)
            .setOnSpotlightStartedListener(object : OnTargetStateChangedListener<CustomTarget> {
                override fun onStarted(target: CustomTarget) {
                    // do something
                }

                override fun onEnded(target: CustomTarget) {
                    // do something
                }
            })
            .build()


        // create spotlight
        Spotlight.with(context)
            .setOverlayColor(R.color.background)
            .setDuration(1000L)
            .setAnimation(AccelerateInterpolator(0f))
            .setTargets(customTarget)
            .setClosedOnTouchedOutside(true)
            .setOnSpotlightStateListener(object : OnSpotlightStateChangedListener {
                override fun onStarted() {
                    Toast.makeText(
                        context,
                        "spotlight is started",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onEnded() {
                    Toast.makeText(
                        context,
                        "spotlight is ended",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            .start()


    }
}