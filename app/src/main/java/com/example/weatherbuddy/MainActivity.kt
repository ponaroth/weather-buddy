package com.androdocs.weatherbuddy

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.androdocs.weatherbuddy.databinding.ActivityMainBinding
import com.example.weatherbuddy.AvatarViewModel
import com.example.weatherbuddy.Main2Activity
import kotlinx.android.synthetic.main.activity_main.view.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.StringWriter
import java.net.URL
import java.util.*
import kotlin.math.roundToInt
import android.R.attr.country
import android.graphics.ColorSpace
import android.util.Log
import org.json.JSONArray
import android.R.string




class MainActivity : AppCompatActivity() {

    var CITY: String = "Los Angeles,US"
    val API: String = "c5bc0d9cc9950915b3cafa0c4a956dc5"

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

//        val text = resources.openRawResource(R.raw.city_list)
//            .bufferedReader().use { it.readText() }
////        val name = []
//        val myList = arrayListOf<String>()
////        val Item = List<string>()
//        var i = 0
//
//
//        var jsonArray = JSONArray(text)
//        for (jsonIndex in 0..(jsonArray.length() - 1)) {
////            Log.d("JSON", jsonArray.getJSONObject(jsonIndex).getString( "name") )
////            myList.append(jsonArray.getJSONObject(jsonIndex).getString( "name"))
//            myList.add( i.toString() + " "+ jsonArray.getJSONObject(jsonIndex).getString( "name")+ ", "+jsonArray.getJSONObject(jsonIndex).getString( "country"))
//
//            i++
//        }
//        System.out.println(myList)
//        val `in`: String
//        val reader = JSONObject(text)
//
//        val sys = reader.getJSONObject("country")
//        print(sys)
//        country = sys.getString("country").toInt()

//        for (i in 0 until text.length()) {
//            val json_data = jsonArray.getJSONObject(i)
//            name[i] = json_data.getString("tienda")
//
//        }
//
//        var tags = ArrayList<String>()
//        // Add the Tag to List
//        tags.add("Android")
//        tags.add("Angular")
//        //Create a Object of Post
//        var post = Post("Json Tutorial", "www.nplix.com", "Pawan Kumar", tags)
//        //Create a Object of Gson
//        var gson = Gson()
//        //Convert the Json object to JsonString
//        var jsonString:String = gson.toJson(post)


//        text.name


// i being the counter of your loop
//        String catId = text.get(i).get("name");
//        if(catId == 3) {
//            ... your code
//        }
        //        System.out.println(text)

//        val `is` = resources.openRawResource(R.raw.city_list)
//        val writer = StringWriter()
//        val buffer = CharArray(1024)
//        try {
//            val reader = BufferedReader(InputStreamReader(`is`, "UTF-8"))
//            var n: Int
//            while ((n = reader.read(buffer)) != -1) {
//                writer.write(buffer, 0, n)
//            }
//        } finally {
//            `is`.close()
//        }
//
//        val jsonString = writer.toString()

        //Initialize AvatarViewModel
        viewModel = ViewModelProviders.of(this).get(AvatarViewModel::class.java)

        //set the data binding to have the initialized AvatarViewModel
        binding.avatarViewModel = viewModel

        //current activity is lifecycle owner of binding, binding can observe LiveData updates
        binding.lifecycleOwner = this


        // get reference to ImageView
//        val iv_click_me = findViewById(R.id.hamburgermenu) as ImageView
        val iv_click_me = binding.hamburgermenu

        // set on-click listener
        iv_click_me.setOnClickListener {

            Toast.makeText(this@MainActivity, "You Clicked : ", Toast.LENGTH_SHORT).show()
            val intent1 = Intent(this, Main2Activity::class.java)//firstActivity
//                    val value = "value"
            intent1.putExtra("my_variable", CITY)
            startActivity(intent1)

            // your code to perform when the user clicks on the ImageView
//            Toast.makeText(this@MainActivity, "You clicked on ImageView.", Toast.LENGTH_SHORT)
//                .show()

//            We add code here for menu
            //Creating the instance of PopupMenu
//            val popup = PopupMenu(this@MainActivity, iv_click_me)
////            //Inflating the Popup using xml file
//            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
//
//            //registering popup with OnMenuItemClickListener
////            popup.setOnMenuItemClickListener { item ->
////                Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT)
////                    .show()
//            true
//            }

//            popup.show()//showing popup menu
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

                //Round temperature to a whole number
                val tempRounded = main.getString("temp").toDouble().roundToInt()
                val temp = "${tempRounded}°"

                val tempMinRounded = main.getString("temp_min").toDouble().roundToInt()
                val tempMin = "Low: $tempMinRounded°"

                val tempMaxRounded = main.getString("temp_max").toDouble().roundToInt()
                val tempMax = "High: $tempMaxRounded°"

                //val temp = main.getString("temp")+"°C"
                //val tempMin = "Low: " + main.getString("temp_min")+"°C"
                //val tempMax = "Max Temp: " + main.getString("temp_max")+"°C"
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
                binding.dateText.text = CITY

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
