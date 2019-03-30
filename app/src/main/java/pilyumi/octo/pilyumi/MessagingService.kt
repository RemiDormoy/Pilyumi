package pilyumi.octo.pilyumi

import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService : FirebaseMessagingService() {

    companion object {
        const val PREF_FCM_TOKEN = "bzrebuvibzreiv"

        fun getToken(context: Context): String? {
            return context.getSharedPreferences("com.octo.rdo.moodmeter", Context.MODE_PRIVATE).getString(
                PREF_FCM_TOKEN, "empty")
        }
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        val sharedPreferences = getSharedPreferences("com.octo.rdo.moodmeter", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(PREF_FCM_TOKEN, p0).apply()
    }

    override fun onMessageReceived(p0: RemoteMessage) {
        Log.d("Message firebase reçu", p0.data.toString())
        val notification = NotificationCompat.Builder(this, "iubvierv")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(p0.data.get("title") ?: "pas de titre")
            .setContentText(p0.data.get("message") ?: "pas de message")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        NotificationManagerCompat.from(this).notify(12, notification)
    }

}