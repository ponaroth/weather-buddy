package com.example.weatherbuddy

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import com.androdocs.weatherbuddy.R




/*
A custom ImageView class that allows a customized selector xml (res/drawable/image_weather_selector.xml) to give a color based off of the
custom state 'weather_condition' that is defined in res/values/attrs.xml.

https://stackoverflow.com/a/34817565 binding non-activity/fragment classses

 */

class MyImageView : ImageView {


    private var mWeatherCondition: String? = ""
    private lateinit var mColor: Color

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(set: AttributeSet?) {
        if (set == null) return

        val typedArray = context.obtainStyledAttributes(set, R.styleable.MyImageView)
        mWeatherCondition = typedArray.getString(R.styleable.MyImageView_weather_condition)

        typedArray.recycle()

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

    }

    private fun setLayerDrawable(){

    }

}