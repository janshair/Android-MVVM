package com.tapdevs.mealsmodule.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tapdevs.base.network.model.meal.category.MealCategory
import com.tapdevs.mealsmodule.databinding.RowMealCategoryBinding
import com.tapdevs.mealsmodule.R
import com.tapdevs.mealsmodule.viewmodels.mealsCategory.MealCategoryViewModel

class MealCategoriesAdapter : RecyclerView.Adapter<MealCategoriesAdapter.MealCategoriesViewHolder>() {

    var mealCategories: List<MealCategory> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCategoriesViewHolder {
        return MealCategoriesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_meal_category, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return mealCategories.size
    }

    override fun onBindViewHolder(holder: MealCategoriesViewHolder, position: Int) {
        mealCategories[position].let {
            with(holder) {
                itemView.tag = it.categoryId
                bind(it)
            }
        }
    }

    fun setItems(mealCategoriesList: List<MealCategory>) {
        this.mealCategories = mealCategoriesList
        notifyDataSetChanged()
    }

    inner class MealCategoriesViewHolder(private val binding: RowMealCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mealCategory: MealCategory) {
            with(binding) {
                mealCategoryViewModel = MealCategoryViewModel(mealCategory)
                executePendingBindings()
            }
        }
    }
}