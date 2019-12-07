package com.example.weatherbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.androdocs.weatherbuddy.MainActivity
import com.androdocs.weatherbuddy.R
import kotlinx.android.synthetic.main.activity_main2.*



class Main2Activity : AppCompatActivity() {
    var hello = ""
    var oldLocation = ""
    var newLocation = ""




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val extras = intent.extras

        if (extras != null) {
            val value = extras.getString("my_variable")
            System.out.println(value)
            findViewById<TextView>(R.id.current_location).text = value
            oldLocation = value

        }



        else{
            System.out.println("Nothing yet")
        }
        val click_me = findViewById(R.id.change_location_button) as Button

        // set on-click listener

        click_me.setOnClickListener {
            Toast.makeText(this@Main2Activity, "BUTTON CLICKED", Toast.LENGTH_SHORT).show()
//            var et = findViewById<TextView>(R.id.inputEditText).text as TextView
            var et= inputEditText.text.toString()
            Toast.makeText(this, et, Toast.LENGTH_SHORT).show()
            current_location.setText(et)
            newLocation = et

            if(hello != ""){
                Toast.makeText(this@Main2Activity, "Changed country to", Toast.LENGTH_SHORT).show()


            }


        }

        val activ_1 = findViewById(R.id.back_to_one) as Button


        activ_1.setOnClickListener{
            Toast.makeText(getApplicationContext(), "OLD LOCATION " + oldLocation,  Toast.LENGTH_SHORT).show();

            if(oldLocation != newLocation){
                System.out.println("old location: "+ oldLocation)
                System.out.println("new location: "+ newLocation)
                Toast.makeText(getApplicationContext(), "In if ",  Toast.LENGTH_SHORT).show();

                val intent1 = Intent(this, MainActivity::class.java)//firstActivity
//                    val value = "value"
                intent1.putExtra("my_variable", newLocation)
                startActivity(intent1)


            }




        }


    }
}
