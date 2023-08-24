package com.example.mad_app085_p5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edt_weburl: EditText = findViewById(R.id.edt_weburl)
        var edt_phone_no: EditText = findViewById<EditText?>(R.id.edt_phoneno)
        var btn_browse: Button = findViewById(R.id.btn_browse)
        var btn_call: Button = findViewById(R.id.btn_call)
        var btn_calllog: Button = findViewById(R.id.btn_calllog)
        var btn_gallery: Button = findViewById(R.id.btn_gallery)
        var btn_camera: Button = findViewById(R.id.btn_camera)
        var btn_alarm: Button = findViewById(R.id.btn_alarm)

        btn_browse.setOnClickListener{
            Intent(Intent.ACTION_VIEW, Uri.parse("https://${edt_weburl.text.toString()}")).also { startActivity(it) }
        }

        btn_call.setOnClickListener {
            Intent(Intent.ACTION_DIAL, Uri.parse("$edt_phone_no")).also { startActivity(it) }
        }

        btn_calllog.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
        }

        btn_gallery.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("Images/*").also { startActivity(it) }
        }

        btn_camera.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }

        btn_alarm.setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }
    }
}