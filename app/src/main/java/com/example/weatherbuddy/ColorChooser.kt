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

The reason that we are using String, String for ArrayMap is that we receive strings from the weather API and store colors as integers.
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

        var temp = value.toInt()

        if(temp >= 100){
            temp = 100
        }
        else if(temp in 99..97){
            temp = 97
        }
        else if(temp in 96..94){
            temp = 94
        }
        else if(temp in 93..85){
            temp = 85
        }
        else if(temp in 84..75){
            temp = 75
        }
        else if(temp in 74..69){
            temp = 69
        }
        else if(temp in 68..58){
            temp = 58
        }
        else if(temp in 57..53){
            temp = 53
        }
        else if(temp in 52..33){
            temp = 33
        }
        else if(temp in 32..11){
            temp = 11
        }
        else
            temp = 0

        return colorMap[temp.toString()]!!
    }

    private fun setTemperatureColors(temperature: Array<String>) {
        val idList = listOf("-114F", "-100F", "-50F", "-32F", "-25F", "0F", "20F", "30F", "40F", "50F", "60F",
             "70F", "80F", "90F", "100F", "110F", "120F")

        for ((index, value) in idList.withIndex()){

            val listColor = temperature[index]

            colorMap[value] = listColor
        }
    }

    public fun getTemperatureColor(value: String): String {

        var temp = value.toInt()

        if(temp <= -114){
            temp = -114
        }
        else if(temp in -113..-100){
            temp = -100
        }
        else if(temp in -99..-50){
            temp = -50
        }
        else if(temp in -49..-32){
            temp = -32
        }
        else if(temp in -31..-25){
            temp = -25
        }
        else if(temp in -24..0){
            temp = -0
        }
        else if(temp in 1..20){
            temp = 20
        }
        else if(temp in 21..30){
            temp = 30
        }
        else if(temp in 31..40){
            temp = 40
        }
        else if(temp in 41..50){
            temp = 50
        }
        else if(temp in 51..60){
            temp = 60
        }
        else if(temp in 61..70){
            temp = 70
        }
        else if(temp in 71..80){
            temp = 80
        }
        else if(temp in 81..90){
            temp = 90
        }
        else if(temp in 91..100){
            temp = 100
        }
        else if(temp in 101..110){
            temp = 110
        }
        else
            temp = 120


        return colorMap[temp.toString()]!!
    }

}