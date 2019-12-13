package com.example.weatherbuddy

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import com.androdocs.weatherbuddy.R
import android.graphics.drawable.LayerDrawable
import android.util.Log





/*
A custom ImageView class that allows a customized selector xml (res/drawable/image_weather_selector2.xmll) to give a color based off of the
custom state 'weather_condition' that is defined in res/values/attrs.xml.

https://developer.android.com/guide/topics/resources/drawable-resource.html
https://android--code.blogspot.com/2015/11/android-how-to-create-layerdrawable.html
 */

class MyImageView : ImageView {


    private var mWeatherCondition: String? = "default"
    private var mColor: Int = -99
    private lateinit var layerDrawable: LayerDrawable
    private lateinit var colorChooser: ColorChooser

    constructor(context: Context) : super(context) {
        setArrayMap()
        setLayerDrawable()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setArrayMap()
        setLayerDrawable()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setArrayMap()
        setLayerDrawable()
    }



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

    private fun setArrayMap(){
        val weatherCondition = context.resources.getStringArray(R.array.weatherCondition)
        val humidity = context.resources.getStringArray(R.array.humidity)
        val temperature = context.resources.getStringArray(R.array.temperature)
        colorChooser = ColorChooser(weatherCondition, humidity, temperature)
    }

    private fun setLayerDrawable() {
        val layers = arrayOf(
            context.getDrawable(R.drawable.ic_bear_logo_left_arm_fur), //index 0 left arm fur
            context.getDrawable(R.drawable.ic_bear_logo_left_arm), //index 1 left arm paw
            context.getDrawable(R.drawable.ic_bear_logo_right_arm_fur), //index 2 right arm fur
            context.getDrawable(R.drawable.ic_bear_logo_right_arm), //index 3 right arm paw
            context.getDrawable(R.drawable.ic_bear_logo_body_fur), //index 4 body fur
            context.getDrawable(R.drawable.ic_bear_logo_body), //index 5 body tummy fur and feet paws
            context.getDrawable(R.drawable.ic_bear_logo_head_fur), //index 6 body head fur
            context.getDrawable(R.drawable.ic_bear_logo_head) //index 7 body face parts
        )

        layerDrawable = LayerDrawable(layers)

        foreground = layerDrawable
    }

    fun setHeadColor(value: String) {
        val color = colorChooser.getTemperatureColor(value)
        layerDrawable.getDrawable(6).setTint(Color.parseColor(color))
    }

    fun setLeftArmColor(value: String) {
        val color = colorChooser.getHumidityColor(value)
        layerDrawable.getDrawable(0).setTint(Color.parseColor(color))
    }

    fun setRightArmColor(value: String) {
        val color = colorChooser.getHumidityColor(value)
        layerDrawable.getDrawable(2).setTint(Color.parseColor(color))
    }

    fun setBodyColor(value: String) {
        val color = colorChooser.getWeatherConditionColor(value)
        layerDrawable.getDrawable(4).setTint(Color.parseColor(color))
    }


}