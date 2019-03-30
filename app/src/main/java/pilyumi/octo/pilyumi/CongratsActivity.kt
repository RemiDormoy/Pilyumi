package pilyumi.octo.pilyumi

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class CongratsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)
        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(HomeActivity.intentForNewFeature(this))
            finish()
        }, 3000)
    }
}
