package com.example.weatherbuddy

import android.content.res.Resources.*
import android.graphics.Color
import android.util.Log
import androidx.collection.ArrayMap
import com.androdocs.weatherbuddy.R



/*
ArrayMap
https://developer.android.com/reference/kotlin/android/util/ArrayMap.html
https://medium.com/@mohom.r/optimising-android-app-performance-with-arraymap-9296f4a1f9eb

Context
https://developer.android.com/reference/android/content/Context

Color
https://developer.android.com/reference/android/graphics/Color.html#parseColor(java.lang.String)

A class that chooses and returns the appropriate color for the Weather Buddy image (MyImageView). Inputs being
current temperature, humidity, and weather condition.

The reason that we are using String, Int for ArrayMap is that we receive strings from the weather API and store colors as integers.
Color.parseColor takes the hex string value and gives RGB Alpha values from 0 to 254.
 */

class ColorChooser {

    private lateinit var colorMap: ArrayMap<String, String>

    constructor(
        weatherCondition: Array<String>,
        humidity: Array<String>,
        temperature: Array<String>
    ) {
        colorMap = ArrayMap<String, String>()
        setWeatherConditionColor(weatherCondition)
        setTemperatureColors(temperature)
        setHumidityColors(humidity)
    }

    //https://stackoverflow.com/a/17584066 help with arrays.xml and accessing them
    //https://stackoverflow.com/a/15068804 getting a resource without context
    private fun setWeatherConditionColor(weatherCondition: Array<String>) {

        val idList = listOf( "200", "201", "202", "210", "211", "212", "221", "230", "231", "232",
            "300", "301", "302", "310", "311", "312", "313", "314", "321",
            "500", "501", "502", "503", "504", "511", "520", "521", "522", "531",
            "600", "601", "602", "611", "612", "613", "615", "616", "620", "621", "622",
            "701", "711", "721", "731", "741", "751", "761", "762", "771", "781",
            "800", "801", "802", "803", "804")

        for ((index, value) in idList.withIndex()){

            val listColor = weatherCondition[index]

            colorMap[value] = listColor
        }

    }

    public fun getWeatherConditionColor(value: String): String {
        return colorMap[value]!!
    }

    private fun setHumidityColors(humidity: Array<String>) {
        val idList = listOf( "100%", "97%", "94%", "85%", "75%", "69%", "58%", "53%", "33%", "11%", "0%")

        for ((index, value) in idList.withIndex()){

            val listColor = humidity[index]

            colorMap[value] = listColor
        }

    }

    public fun getHumidityColor(value: String): String {
        return colorMap[value]!!
    }

    private fun setTemperatureColors(temperature: Array<String>) {
        val idList = listOf("-114F", "-100F", "-50F", "-31F", "-25F", "0F", "20F", "30F", "40F", "50F", "60F",
             "70F", "80F", "90F", "100F", "110F", "120F")

        for ((index, value) in idList.withIndex()){

            val listColor = temperature[index]

            colorMap[value] = listColor
        }
    }

    public fun getTemperatureColor(value: String): String {
        return colorMap[value]!!
    }

}