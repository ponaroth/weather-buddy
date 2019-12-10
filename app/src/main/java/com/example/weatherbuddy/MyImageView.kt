package com.example.weatherbuddy

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import com.androdocs.weatherbuddy.R
import android.graphics.drawable.LayerDrawable
import android.util.Log
import androidx.annotation.ColorInt
import androidx.core.graphics.toColor
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable
import com.sdsmdg.harjot.vectormaster.models.PathModel



/*
A custom ImageView class that allows a customized selector xml (res/drawable/image_weather_selector2.xmll) to give a color based off of the
custom state 'weather_condition' that is defined in res/values/attrs.xml.

https://developer.android.com/guide/topics/resources/drawable-resource.html
https://android--code.blogspot.com/2015/11/android-how-to-create-layerdrawable.html

https://proandroiddev.com/advanced-data-binding-binding-to-livedata-one-and-two-way-binding-dae1cd68530f Binding Adapters Resource
 */

class MyImageView : ImageView {


    private var mWeatherCondition: String? = "default"
    private var mColor: Int = -99
    private lateinit var layerDrawable: LayerDrawable
    private lateinit var colorChooser: ColorChooser
    private lateinit var headSkinVector: VectorMasterDrawable

    /*
    These are the variables that are used in the bindable adapters in AvatarViewModel.
    When they are changed from AvatarViewModel then that change also happens here.
    This is set up through activity_main with the custom attributes and the @Bindable-Adaptar
    in AvatarViewModel.
     */

    //to use two way binding you must have a setter for your binded variables

/*    var condition: String = ""
        set(value) {
            field = value
            invalidate()
        }

    var temperature: String = "80F"
        set(value) {
            field = value
            invalidate()
        }
    var humidity: String = "65%"
        set(value) {
            field = value
            invalidate()
        }*/


    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(set: AttributeSet?) {
        //if (set == null) return

        val typedArray = context.obtainStyledAttributes(set, R.styleable.MyImageView)

        mWeatherCondition = typedArray.getString(R.styleable.MyImageView_condition)

        Log.i("MyImageView", "$mWeatherCondition")

        typedArray.recycle()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setLayerDrawable()

        val headSkinVector = VectorMasterDrawable(context, R.drawable.ic_bear_logo_head)

        val weatherCondition = context.resources.getStringArray(R.array.weatherCondition)
        val humidity = context.resources.getStringArray(R.array.humidity)
        val temperature = context.resources.getStringArray(R.array.temperature)

        colorChooser = ColorChooser(weatherCondition, humidity, temperature)

        //val outline: PathModel = headSkinVector.getPathModelByName("leftEar")
        //outline.fillColor(Color.parseColor("#FF69B4"))


    }

    private fun setLayerDrawable() {
        val layers = arrayOf(
            context.getDrawable(R.drawable.ic_bear_logo_head), //index 0
            context.getDrawable(R.drawable.ic_bear_logo_left_arm), //index 1
            context.getDrawable(R.drawable.ic_bear_logo_right_arm), //index 2
            context.getDrawable(R.drawable.ic_bear_logo_body) //index 3
        )

        layerDrawable = LayerDrawable(layers)

        foreground = layerDrawable
    }

    fun setHeadColor(value: String) {
        val color = colorChooser.getTemperatureColor(value)
        layerDrawable.getDrawable(0).setTint(Color.parseColor(color))
    }

    fun setLeftArmColor(value: String) {
        val color = colorChooser.getHumidityColor(value)
        layerDrawable.getDrawable(1).setTint(Color.parseColor(color))
    }

    fun setRightArmColor(value: String) {
        val color = colorChooser.getHumidityColor(value)
        layerDrawable.getDrawable(2).setTint(Color.parseColor(color))
    }

    fun setBodyColor(value: String) {
        val color = colorChooser.getWeatherConditionColor(value)
        layerDrawable.getDrawable(3).setTint(Color.parseColor(color))
    }


}