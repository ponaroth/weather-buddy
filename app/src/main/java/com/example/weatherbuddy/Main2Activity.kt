package com.example.weatherbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.androdocs.weatherbuddy.MainActivity

import com.androdocs.weatherbuddy.R
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray
import java.net.URL


class Main2Activity : AppCompatActivity() {
    var hello = ""
    var oldLocation = ""
    var newLocation = ""







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        private lateinit var binding: ActivityMain2Binding

//        val text = resources.openRawResource(R.raw.city_list)
//            .bufferedReader().use { it.readText() }
////        val name = []
//        val myList = arrayListOf<String>()
////        val Item = List<string>()
//        var i = 0
//        var myList1 = ""

//        findViewById<TextView>(R.id.countries).text = myList1
//
//
//        var jsonArray = JSONArray(text)
//        for (jsonIndex in 0..(jsonArray.length() - 1)) {
////            Log.d("JSON", jsonArray.getJSONObject(jsonIndex).getString( "name") )
////            myList.append(jsonArray.getJSONObject(jsonIndex).getString( "name"))
//            myList.add( i.toString() + " "+ jsonArray.getJSONObject(jsonIndex).getString( "name")+ ", "+jsonArray.getJSONObject(jsonIndex).getString( "country")+"\n")
//
//            i++
//        }
////        System.out.println(myList.toString())
////        var i2 = 0
////        for (i2 in myList){
////            System.out.println(i2)
////            System.out.println("\n")
////        }
//
//
////        myList1.append
//        findViewById<TextView>(R.id.countries).text = myList.toString()
//        textArea.setText(sb.toString());




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

        var count = 0


        click_me.setOnClickListener {
            //Toast.makeText(this@Main2Activity, "BUTTON CLICKED", Toast.LENGTH_SHORT).show()
//            var et = findViewById<TextView>(R.id.inputEditText).text as TextView
            var et= inputEditText.text.toString()
            //Toast.makeText(this, et, Toast.LENGTH_SHORT).show()
//            current_location.setText(et)
            newLocation = et

            if(hello != ""){
                //Toast.makeText(this@Main2Activity, "Changed country to", Toast.LENGTH_SHORT).show()


            }

            val API: String = "c5bc0d9cc9950915b3cafa0c4a956dc5"

            var response:String?






            val thread = Thread(Runnable {
                try{

                    response = URL("https://api.openweathermap.org/data/2.5/weather?q=$newLocation&units=imperial&appid=$API").readText(
                        Charsets.UTF_8)
                    current_location.setText(newLocation)
                    count = 1

                }catch (e: Exception){
                    count = 0
                    response = null
                    var city_file = URL("http://bulk.openweathermap.org/sample/ for valid downloads")
//                    var city_file = "<a href=http://bulk.openweathermap.org/sample/ >Google</a>"
//                    current_location.setText("Not a valid country: refer to city.list.json file located at" + city_file)
                    current_location.setText("Not valid city, valid cities located on openweathermap.org")
                    System.out.println("Error"+ e)
                    System.out.println("Not working link: "+"https://api.openweathermap.org/data/2.5/weather?q=$newLocation&units=imperial&appid=$API")

                }
                System.out.println("This is the response in the loop"+response)
                System.out.println("This is the new city"+newLocation)
            })

            thread.start();




        }

        val activ_1 = findViewById(R.id.back_to_one) as Button


        activ_1.setOnClickListener{
            //Toast.makeText(getApplicationContext(), "OLD LOCATION " + oldLocation,  Toast.LENGTH_SHORT).show();

            if(oldLocation != newLocation && count == 1){
                System.out.println("old location: "+ oldLocation)
                System.out.println("new location: "+ newLocation)
                //Toast.makeText(getApplicationContext(), "In if ",  Toast.LENGTH_SHORT).show();

                val intent1 = Intent(this, MainActivity::class.java)//firstActivity
//                    val value = "value"
                intent1.putExtra("my_variable", newLocation)
                startActivity(intent1)





            }

            else{
                val intent1 = Intent(this, MainActivity::class.java)//firstActivity
//                    val value = "value"
                intent1.putExtra("my_variable", oldLocation)
                startActivity(intent1)
            }

//            var CITY: String = "London,GB"






        }


    }
}
