package pilyumi.octo.pilyumi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.collapsing_toolbar.*
import kotlinx.android.synthetic.main.collpasing_stuff.*
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collapsing_toolbar)
        val now = LocalTime.now()
        val pillTime = LocalTime.of(20, 0)
        val between = (pillTime.toSecondOfDay() - now.toSecondOfDay()) * 1000
        supportActionBar?.hide()
        object : CountDownTimer(between.toLong(), 1000.toLong()) {
            override fun onFinish() {
                // Do nothing for now
            }

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = LocalTime.ofSecondOfDay(millisUntilFinished / 1000).format(DateTimeFormatter.ofPattern("HH:mm:ss"))
            }

        }.start()
        scrollViewRoot.viewTreeObserver.addOnScrollChangedListener {
            val expand = findViewById<View>(R.id.collapsYolo)
            val collapsed = findViewById<View>(R.id.collapsedCalendarContainer)
            val percent = scrollViewRoot.scrollY.toFloat() / expand.height.toFloat()
            when {
                percent > 0.5f -> {
                    expand.alpha = 0f
                    collapsed.alpha = 1f
                }
                percent < 0.4f -> {
                    expand.alpha = 1f
                    collapsed.alpha = 0f
                }
                else -> {
                    expand.alpha = (1 - ((percent - 0.4)) * 10).toFloat()
                    val toFloat = ((percent - 0.4) * 10).toFloat()
                    collapsed.alpha = toFloat
                }
            }
        }
    }
}
