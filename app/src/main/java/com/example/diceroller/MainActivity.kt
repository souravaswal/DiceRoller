package com.example.diceroller

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                hideDice()
                val random1 = (1..6).random()
                textView.text = random1.toString()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }
        }
        )
    }

    private fun hideDice() {
        dice.visibility = View.GONE
        textView.visibility = View.VISIBLE
        button.isEnabled = true
    }

    private fun showDice()
    {
        dice.visibility = View.VISIBLE
        textView.visibility = View.GONE
        button.isEnabled = false
    }

    fun rollDice(view: View) {
        showDice()
        dice.playAnimation()
    }
}