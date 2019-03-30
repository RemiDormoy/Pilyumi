package pilyumi.octo.pilyumi

import android.animation.ValueAnimator
import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.util.TypedValue
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quizz.*
import kotlinx.android.synthetic.main.first_question.*
import kotlinx.android.synthetic.main.second_question.*
import kotlinx.android.synthetic.main.third_question.*

class QuizzActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)
        firstQuestionButton.setOnClickListener {
            firstSuccessView.animate().alpha(1f).withEndAction {
                firstLottieView.playAnimation()
                Handler().postDelayed({
                    moveTo2()
                }, 1000)
            }
        }
        secondQuestionButton.setOnClickListener {
            secondSuccessView.animate().alpha(1f).withEndAction {
                secondLottieView.playAnimation()
                Handler().postDelayed({
                    moveTo3()
                }, 1000)
            }
        }
        thirdQuestionButton.setOnClickListener {
            thirdQuestionButton.setBackgroundResource(R.drawable.rounded_fill)
            thirdQuestionButton.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            Handler().postDelayed({
                finish()
            }, 2000)
        }
    }

    private fun moveTo2() {
        val animator = ValueAnimator.ofInt(0, 1000)
        animator.addUpdateListener {
            val value = it.animatedValue as Int
            cardFirstQuestion.translationX = -value.toFloat()

            cardSecondQuestion.translationX = ((1000f - value) / 1000f) * 50.toDp(resources)
            cardSecondQuestion.translationY = ((1000f - value) / 1000f) * 10.toDp(resources)
            cardSecondQuestion.rotation = 5 * (1000f - value) / 1000f

            cardThirdQuestion.translationX = ((1000f - value) / 1000f) * 70.toDp(resources) + (value / 1000f) * 50.toDp(resources)
            cardThirdQuestion.translationY = ((1000f - value) / 1000f) * 30.toDp(resources) + (value / 1000f) * 10.toDp(resources)
            cardThirdQuestion.rotation = 5 * (1000f - value) / 1000f + (value / 1000f) * 5
        }
        animator.duration = 500
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.start()
    }

    private fun moveTo3() {
        val animator = ValueAnimator.ofInt(0, 1000)
        animator.addUpdateListener {
            val value = it.animatedValue as Int
            cardSecondQuestion.translationX = -value.toFloat()

            cardThirdQuestion.translationX = ((1000f - value) / 1000f) * 50.toDp(resources)
            cardThirdQuestion.translationY = ((1000f - value) / 1000f) * 10.toDp(resources)
            cardThirdQuestion.rotation = 5 * (1000f - value) / 1000f
        }
        animator.duration = 500
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.start()
    }

}

fun Int.toDp(resources: Resources) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this.toFloat(),
    resources.getDisplayMetrics()
)

fun Float.toDp(resources: Resources) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    resources.getDisplayMetrics()
)
