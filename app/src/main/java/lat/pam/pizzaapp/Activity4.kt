package lat.pam.pizzaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class Activity4 : AppCompatActivity() {
    val EXTRA_NAME = "com.example.android.activities.extra.NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)


        val intent = intent
        val message = intent.getStringExtra(EXTRA_NAME)
        intent.putExtra(EXTRA_NAME, message)

        val orderButton = findViewById<Button>(R.id.orderBtn)
        orderButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Activity5::class.java)
            intent.putExtra(EXTRA_NAME, message)
            startActivity(intent)
        })

        val backButton = findViewById<Button>(R.id.backBtn)
        backButton?.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }
}