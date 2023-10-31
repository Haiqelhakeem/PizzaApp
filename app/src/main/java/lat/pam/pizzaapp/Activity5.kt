package lat.pam.pizzaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Activity5 : AppCompatActivity() {
    val EXTRA_NAME = "com.example.android.activities.extra.NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)

        val intent = intent
        val message = intent.getStringExtra(EXTRA_NAME)

        val textView = findViewById<TextView>(R.id.nameCustomer)
        textView.text ="Customer: $message"

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val doneButton = findViewById<Button>(R.id.doneBtn)

        doneButton.setOnClickListener(View.OnClickListener {
            val notification = findViewById<TextView>(R.id.orderNotif)
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectedOption = selectedRadioButton.text.toString()
                notification.text = "Terima kasih $message telah membeli Pizza Pepperoni dengan metode pengambilan $selectedOption"
            } else {
                notification.text = "Silakan pilih metode pengambilan"
            }
            notification.visibility = View.VISIBLE
        })
    }
}