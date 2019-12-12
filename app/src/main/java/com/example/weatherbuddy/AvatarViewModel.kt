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
    val avatar: MutableLiveData<String> = MutableLiveData<String>()

    //The current weather condition
    val weatherCondition: MutableLiveData<String> = MutableLiveData<String>()

    //The current humidity
    val humidity: MutableLiveData<String> = MutableLiveData<String>()

    //The current temperature
    val temperature: MutableLiveData<String> = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        Log.i("AvatarViewModel", "AvatarViewModel destroyed!")
    }

}