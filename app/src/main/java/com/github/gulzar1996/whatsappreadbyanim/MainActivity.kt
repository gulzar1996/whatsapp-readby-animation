package com.github.gulzar1996.whatsappreadbyanim
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.view.View

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.readby_collapsed)
        val constraintSet1 = ConstraintSet()
        val constraintSet2 = ConstraintSet()
        var changed = false

        constraintSet1.clone(constraintLayout)
        constraintSet2.clone(this,R.layout.readby_expanded)

        //Touch Listener
        findViewById<View>(R.id.touch).setOnClickListener({
            TransitionManager.beginDelayedTransition(constraintLayout)
            val constraint = if (changed) constraintSet1 else constraintSet2
            constraint.applyTo(constraintLayout)
            changed = !changed
        })


    }
}
