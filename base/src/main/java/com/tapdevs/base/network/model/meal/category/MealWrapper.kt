package com.tapdevs.base.network.model.meal.category

import com.google.gson.annotations.SerializedName

data class MealWrapper(
    @SerializedName("categories")
    var meals: MutableList<Meal>? = null
)