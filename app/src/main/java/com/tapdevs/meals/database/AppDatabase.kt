package com.tapdevs.meals.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.tapdevs.base.network.model.meal.category.MealCategory

@Database(entities = [MealCategory::class], version = 1, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {


}