package pilyumi.octo.pilyumi

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class PilyumiApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}