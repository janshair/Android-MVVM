package com.tapdevs.mealsmodule.viewmodels.mealsCategory

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.tapdevs.base.network.model.meal.category.MealCategory

class MealCategoryViewModel(mealCategory: MealCategory) : ViewModel() {
    val imageUrl =
        ObservableField<String>(mealCategory.categoryThumb)
    val mealCategory =
        ObservableField<String>(mealCategory.category)
    val mealCategoryId =
        ObservableField<String>(mealCategory.categoryId)
    val mealCategoryDescription =
        ObservableField<String>(mealCategory.categoryDescription)
}