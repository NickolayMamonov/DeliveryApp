package com.whysoezzy.deliveryapp.ui.screens.home

import androidx.annotation.DrawableRes
import kotlin.random.Random

data class Food(
    val name: String,
    @DrawableRes val image: Int,
    val type: FoodType,
    val liked: Boolean = false,
    val price: Int = Random.nextInt(10, 100)

)

enum class FoodType {
    Meal, Side, Snack
}

