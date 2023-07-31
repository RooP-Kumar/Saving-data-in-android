package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment

class MainActivity : AppCompatActivity() {


    lateinit var fetchBtn: Button
    lateinit var saveBtn: Button
    lateinit var fetchData: EditText
    lateinit var text1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchData = findViewById(R.id.fetchData)
        text1 = findViewById(R.id.text)
        fetchBtn = findViewById(R.id.fetch)
        saveBtn = findViewById(R.id.save)


        saveBtn.setOnClickListener {
            val str: String? = (fetchData.text).toString()
            val share: SharedPreferences = getSharedPreferences("Demo", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = share.edit()

            editor.putString("msg", str)
            editor.apply()
            text1.text = str
        }

        val fetch_data: SharedPreferences = getSharedPreferences("Demo", MODE_PRIVATE)
        val fetched = fetch_data.getString("msg", "Plese Enter something to save in textview.")
        text1.text = fetched

    }
}
