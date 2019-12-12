package com.example.weatherbuddy

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androdocs.weatherbuddy.R




/*
* ViewModel for the changing image avatar whose image changes based of the states of
* temperature, weather condition, and humidity from the openweathermap API. The use of LiveData
* allows for observation of the change of the three states for dynamic image change. Business logic for
* our custom ImageView widget (MyImageView) is also separated from UI using ViewModel.
*/
class AvatarViewModel : ViewModel() {

    //The current avatar ImageView
    private var _avatar = MutableLiveData<MyImageView>()
    val avatar: LiveData<MyImageView>
        get() = _avatar

    //The current weather condition
    private var _weatherCondition = MutableLiveData<String>()
    val weatherCondition: LiveData<String>
        get() = _weatherCondition

    //The current humidity
    private var _humidity = MutableLiveData<String>()
    val humidity: MutableLiveData<String> = MutableLiveData<String>()

    //The current temperature
    private var _temperature = MutableLiveData<String>()
    val temperature: LiveData<String>
        get() = _temperature

    override fun onCleared() {
        super.onCleared()
        Log.i("AvatarViewModel", "AvatarViewModel destroyed!")
    }

}