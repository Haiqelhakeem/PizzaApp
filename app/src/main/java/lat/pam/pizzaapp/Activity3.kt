package lat.pam.pizzaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity3 : AppCompatActivity(), ItemAdapter.ItemClickListener {
    val EXTRA_NAME = "com.example.android.activities.extra.NAME"

    private val itemList = listOf(
        ItemAdapter.Item(
            R.drawable.circle_cropped__27__1, "Pepperoni Pizza",
            "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat"
        ),
        ItemAdapter.Item(
            R.drawable.circle_cropped__26__1, "Spaghetti",
            "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental"
        ),
        ItemAdapter.Item(
            R.drawable.circle_cropped__25__1, "Burger",
            "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal"
        ),
        ItemAdapter.Item(
            R.drawable.circle_cropped__25__2, "Steak",
            "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val intent = intent
        val message = intent.getStringExtra(EXTRA_NAME)
        val textView = findViewById<TextView>(R.id.name_navbar)
        textView.text = message

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        val adapter = ItemAdapter(itemList, this)


        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }


    override fun onItemClick(position: Int) {
        val selectedItem = itemList[position]
        val intent2 = Intent(this, Activity4::class.java)
        val intent = intent
        val message = intent.getStringExtra(EXTRA_NAME)
        intent2.putExtra(EXTRA_NAME, message)
        val test = message.toString()
//        Log.d("test", test)

        startActivity(intent2)
    }
}