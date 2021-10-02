package com.example.registrodesuperheroes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SuperHero(val name:String, val alterEgo: String, val bio:String, val power: Float) :
    Parcelable {

}