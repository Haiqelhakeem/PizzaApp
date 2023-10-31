package lat.pam.pizzaapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.activities.extra.MESSAGE"
    val EXTRA_NAME = "com.example.android.activities.extra.NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.name_navbar)
        textView.text = message

        val menuBtn = findViewById<Button>(R.id.seeMenuBtn)

        menuBtn?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Activity3::class.java)
            intent.putExtra(EXTRA_NAME, message)
            startActivity(intent)
        })
    }
}