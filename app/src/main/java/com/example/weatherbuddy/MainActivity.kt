package com.androdocs.weatherbuddy

import android.os.AsyncTask
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.androdocs.weatherbuddy.databinding.ActivityMainBinding
import com.example.weatherbuddy.AvatarViewModel
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import java.nio.file.Files.delete
import android.content.Intent
import com.example.weatherbuddy.Main2Activity


class MainActivity : AppCompatActivity() {
//check if commits working
    var CITY: String = "Los Angeles,US"
//    var CITY: String = "London,GB"
    val API: String = "c5bc0d9cc9950915b3cafa0c4a956dc5"
    var id = 0

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: AvatarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bind activity_main.xml
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val extras = intent.extras

        if (extras != null) {
            val value = extras.getString("my_variable")
            System.out.println(value)

            if(value != CITY){
                System.out.println("VALUE DOES NOT EQUAL CITY"+value+"not"+CITY)

//                findViewById<TextView>(R.id.current_location).text = value
                CITY = value
                System.out.println("NEW CITY ADDED!City is now" + CITY)


            }


        }

        weatherTask().execute()

        //Initialize AvatarViewModel
        viewModel = ViewModelProviders.of(this).get(AvatarViewModel::class.java)

        //set the data binding to have the initialized AvatarViewModel
        binding.avatarViewModel = viewModel



        //current activity is lifecycle owner of binding, binding can observe LiveData updates
        binding.lifecycleOwner = this



        // get reference to ImageView
        val iv_click_me = findViewById(R.id.hamburgermenu) as ImageView
        // set on-click listener
        iv_click_me.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this@MainActivity, "You clicked on ImageView.", Toast.LENGTH_SHORT)
                .show()

//            We add code here for menu
            //Creating the instance of PopupMenu
            val popup = PopupMenu(this, iv_click_me)
//            //Inflating the Popup using xml file

            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.one ->
//                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                              id = 1
                    R.id.two ->id = 2
//                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.three ->id=3
//                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }

                if(id == 1){
                    Toast.makeText(this@MainActivity, "You Clicked : ", Toast.LENGTH_SHORT).show()
                    val intent1 = Intent(this, Main2Activity::class.java)//firstActivity
//                    val value = "value"
                    intent1.putExtra("my_variable", CITY)
                    startActivity(intent1)

                }
                else if(id == 2){
                    Toast.makeText(this@MainActivity, "You Clicked : ", Toast.LENGTH_SHORT).show()
                    val intent1 = Intent(this, MainActivity::class.java)//firstActivity
                    startActivity(intent1)

                }
                else if(id == 3){

                }
                else{
                    Toast.makeText(this@MainActivity, "You Clicked : ", Toast.LENGTH_SHORT).show()
                    val intent1 = Intent(this, MainActivity::class.java)//firstActivity
                    startActivity(intent1)
                }




                true
            })




            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)



            //registering popup with OnMenuItemClickListener
//            popup.setOnMenuItemClickListener { item ->
//                Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT)
//                    .show()

//            }

            popup.show()//showing popup menu
//            We end code here for menu




        }




    }

//    fun onMenuItemClick(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            R.id.one -> {
////                archive(item)
//                Toast.makeText(this@MainActivity, "You clicked on ImageView.", Toast.LENGTH_SHORT)
//                    .show()
//
//                return true
//            }
//            R.id.two -> {
////                delete(item)
//                return true
//            }
//            else -> return false
//        }
//    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            // Showing the ProgressBar, Making the main design GONE
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            //findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }

        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            try{
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=imperial&appid=$API").readText(
                    Charsets.UTF_8
                )
            }catch (e: Exception){
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {

            val sdf = SimpleDateFormat("EEEE d MMMM yyyy")
            val currentDate = sdf.format(Date())

            System.out.println(" C DATE is  "+currentDate)
            super.onPostExecute(result)
            try {
                // Extracting JSON returns from the API
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

                val temp = main.getString("temp")+"°F"
                val tempMin = "Min Temp: " + main.getString("temp_min")+"°F"
                val tempMax = "Max Temp: " + main.getString("temp_max")+"°F"
                val humidity = "Humidity: " + main.getString("humidity")
                val windSpeed = "Wind: " + wind.getString("speed")
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name")+", "+sys.getString("country")

                // Populating extracted data into our views
                findViewById<TextView>(R.id.address).text = address
                findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
                findViewById<TextView>(R.id.temp).text = temp
                findViewById<TextView>(R.id.temp_min).text = tempMin
                findViewById<TextView>(R.id.temp_max).text = tempMax

                findViewById<TextView>(R.id.wind).text = windSpeed
                findViewById<TextView>(R.id.humidity).text = humidity
                findViewById<TextView>(R.id.date_textView).text = currentDate


                // Views populated, Hiding the loader, Showing the main design
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                //findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE

            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
            //hello

        }
    }
}

