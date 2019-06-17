package com.tapdevs.base.network.model.meal.category

import com.google.gson.annotations.SerializedName

data class MealCategoryList(
    @SerializedName("categories")
    val categories: List<MealCategory>
)