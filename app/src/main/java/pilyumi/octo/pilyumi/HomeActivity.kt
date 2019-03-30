package pilyumi.octo.pilyumi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_home.*
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val now = LocalTime.now()
        val pillTime = LocalTime.of(20, 0)
        val between = (pillTime.toSecondOfDay() - now.toSecondOfDay()) * 1000
        val timer = object : CountDownTimer(between.toLong(), 1000.toLong()) {
            override fun onFinish() {
                // Do nothing for now
            }

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = LocalTime.ofSecondOfDay(millisUntilFinished / 1000).format(DateTimeFormatter.ofPattern("HH:mm:ss"))
            }

        }.start()
    }
}
