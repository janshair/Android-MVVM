package com.tapdevs.base.network.model.meal.category

import com.google.gson.annotations.SerializedName

data class MealCategoryWrapper(
    @SerializedName("categories")
    var categories: MutableList<MealCategory>? = null
)