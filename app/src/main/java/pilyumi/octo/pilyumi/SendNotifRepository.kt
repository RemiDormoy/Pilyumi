package pilyumi.octo.pilyumi

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

class SendNotifRepository {

    private val client = OkHttpClient()

    fun sendNotif() {
        val token =""
        val body = Body(token, BodyData("message", "title", "yolo title", "yolo message"))
        try {
            val request = Request.Builder()
                .addHeader("Authorization", "key=AAAAbj2oAkg:APA91bG5kfMrZK0wRUqSFe5qSDuxdkXEv_AECea-GaqAOrxPStBDMaDrCJnrm4aWliPzHJml81vAcwkmH40ooHNswiQ0qhkyF5afAC2MERb-FpIvjjSnPYLFXlOvnJ9wBE0Z5stdD616")
                .addHeader("Content-Type", "application/json")
                .url("https://fcm.googleapis.com/fcm/send")
                .post(
                    RequestBody.create(
                        MediaType.parse("application/json; charset=utf-8"),
                        Gson().toJson(body)
                    )
                )
                .build()
            client.newCall(request).execute()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    data class Body(
        val to: String,
        val data: BodyData
    )

    data class BodyData(
        val message: String,
        val title: String,
        val question: String,
        val idRetro: String?
    )

}