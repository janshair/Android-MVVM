package com.tapdevs.mealsmodule.viewmodels.mealsCategory

import com.tapdevs.base.network.model.meal.category.MealCategory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MealCategoryViewModelTest {

    private lateinit var mealCategory: MealCategory

    private lateinit var mealCategoryViewModel: MealCategoryViewModel

    @Before
    fun setUp(){
        mealCategory = MealCategory("1", "Chicken", "", "This is dummy")
        mealCategoryViewModel = MealCategoryViewModel(mealCategory)
    }

    @Test
    fun assertEqualsImageUrl_ReturnsTrue() {
        assertEquals("", mealCategoryViewModel.imageUrl.get())
    }

    @Test
    fun assertEqualsCategoryId_ReturnsTrue() {
        assertEquals("1",mealCategoryViewModel.mealCategoryId.get())
    }

    @Test
    fun assertEqualsCategory_ReturnsTrue() {
        assertEquals("Chicken",mealCategoryViewModel.mealCategory.get())
    }

    @Test
    fun assertEqualsCategoryDescription_ReturnsTrue() {
        assertEquals("This is dummy",mealCategoryViewModel.mealCategoryDescription.get())
    }
}