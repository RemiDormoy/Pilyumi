package pilyumi.octo.pilyumi

import android.animation.ArgbEvaluator
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_home_root.*
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.os.Handler
import kotlinx.android.synthetic.main.fragment_streak.*


class HomeActivity : AppCompatActivity() {

    companion object {
        fun intentForNewFeature(context: Context) = Intent(context, HomeActivity::class.java)
            .putExtra("isWithNewFeature", true)
    }

    private val evaluator: ArgbEvaluator by lazy {
        ArgbEvaluator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_root)
        supportActionBar?.hide()
        initTimer()
        viewPagerHome.setPadding(150, 0, 150, 50)
        viewPagerHome.clipToPadding = false
        viewPagerHome.pageMargin = 50
        val homePagerAdapter = HomePagerAdapter(supportFragmentManager)
        viewPagerHome.adapter = homePagerAdapter
        viewPagerHome.currentItem = if (intent.getBooleanExtra("isWithNewFeature", false)) {
            Handler().postDelayed({
                lottieNew.setMaxProgress(0.66f)
                lottieNew.playAnimation()
            }, 500)
            2
        } else {
            1
        }
        viewPagerHome.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrolled(position: Int,
                                        positionOffset: Float,
                                        positionOffsetPixels: Int) {
                val newPosition = position + positionOffset
                val color = if (newPosition < 1) {
                    evaluator.evaluate(newPosition,
                        ContextCompat.getColor(this@HomeActivity, R.color.color1),
                        ContextCompat.getColor(this@HomeActivity, R.color.color2)) as Int
                } else {
                    evaluator.evaluate(newPosition - 1,
                        ContextCompat.getColor(this@HomeActivity, R.color.color2),
                        ContextCompat.getColor(this@HomeActivity, R.color.color3)) as Int
                }
                rootContainer.setBackgroundColor(color)
            }

        })
    }

    private fun initTimer() {
        val now = LocalTime.now()
        val pillTime = LocalTime.of(20, 0)
        val between = (pillTime.toSecondOfDay() - now.toSecondOfDay()) * 1000
        object : CountDownTimer(between.toLong(), 1000.toLong()) {
            override fun onFinish() {
                // Do nothing for now
            }

            override fun onTick(millisUntilFinished: Long) {
//                timerTextView.text = LocalTime.ofSecondOfDay(millisUntilFinished / 1000).format(DateTimeFormatter.ofPattern("HH:mm:ss"))
            }

        }.start()
    }

}
