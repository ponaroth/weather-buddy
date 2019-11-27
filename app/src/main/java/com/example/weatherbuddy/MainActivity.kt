package com.androdocs.weatherbuddy

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
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
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
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
                //findViewById<TextView>(R.id.address).text = address
                //findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
                //findViewById<TextView>(R.id.temp).text = temp
                //findViewById<TextView>(R.id.temp_min).text = tempMin
                //findViewById<TextView>(R.id.temp_max).text = tempMax
                //findViewById<TextView>(R.id.wind).text = windSpeed
                //findViewById<TextView>(R.id.humidity).text = humidity

                // Populating extracted data into our views
                binding.address.text = address
                binding.status.text = weatherDescription.capitalize()
                binding.temp.text = temp
                binding.minTemp.text = tempMin //Changed temp_min to minTemp in xml
                binding.maxTemp.text = tempMax //Changed temp_max to maxTemp in xml
                binding.wind.text = windSpeed
                binding.humidity.text = humidity

                // Views populated, Hiding the loader, Showing the main design
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                //findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE

            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }

        }
    }
}
