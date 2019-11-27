package com.androdocs.weatherbuddy

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.androdocs.weatherbuddy.databinding.ActivityMainBinding
import com.example.weatherbuddy.AvatarViewModel
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    val CITY: String = "Los Angeles,US"
    val API: String = "c5bc0d9cc9950915b3cafa0c4a956dc5"

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: AvatarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bind activity_main.xml
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
//            Toast.makeText(this@MainActivity, "You clicked on ImageView.", Toast.LENGTH_SHORT)
//                .show()

//            We add code here for menu
            //Creating the instance of PopupMenu
            val popup = PopupMenu(this@MainActivity, iv_click_me)
//            //Inflating the Popup using xml file
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)

            //registering popup with OnMenuItemClickListener
//            popup.setOnMenuItemClickListener { item ->
//                Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT)
//                    .show()
            true
//            }

            popup.show()//showing popup menu
//            We end code here for menu
        }


    }

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
            super.onPostExecute(result)
            try {
                // Extracting JSON returns from the API
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

                val temp = main.getString("temp")+"°C"
                val tempMin = "Min Temp: " + main.getString("temp_min")+"°C"
                val tempMax = "Max Temp: " + main.getString("temp_max")+"°C"
                val humidity = "Humidity: " + main.getString("humidity")
                val windSpeed = "Wind: " + wind.getString("speed")
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name")+", "+sys.getString("country")

                // Populating extracted data into our views
                binding.address.text = address
                binding.status.text = weatherDescription.capitalize()
                binding.temp.text = temp
                binding.minTemp.text = tempMin
                binding.maxTemp.text = tempMax
                binding.wind.text = windSpeed
                binding.humidity.text = humidity


                // Views populated, Hiding the loader, Showing the main design
                binding.loader.visibility = View.GONE
                //findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE

            } catch (e: Exception) {
                //findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                //findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
                binding.loader.visibility = View.GONE
                binding.errorText.visibility = View.GONE
            }

        }
    }
}
