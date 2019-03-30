package pilyumi.octo.pilyumi

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_streak.*
import kotlinx.android.synthetic.main.streak_unleashed.*

class StreakActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streak)
        supportActionBar?.hide()
        closeImageViewStreak.setOnClickListener {
            onBackPressed()
        }
    }

}
