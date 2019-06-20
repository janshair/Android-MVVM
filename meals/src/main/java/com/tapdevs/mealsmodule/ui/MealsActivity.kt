package com.tapdevs.mealsmodule.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.tapdevs.base.ui.BaseActivity
import com.tapdevs.mealsmodule.R
import com.tapdevs.mealsmodule.databinding.ActivityMealBinding
import com.tapdevs.mealsmodule.ui.adapter.MealCategoriesAdapter
import com.tapdevs.mealsmodule.viewmodels.mealsCategory.MealCategoryViewModelList
import kotlinx.android.synthetic.main.activity_meal.*
import kotlinx.android.synthetic.main.view_offline.*
import javax.inject.Inject

class MealsActivity : BaseActivity() {

    @Inject lateinit var mealCategoryViewModel: MealCategoryViewModelList

    @Inject lateinit var adapter: MealCategoriesAdapter

    override val layoutResourceId: Int
        get() = R.layout.activity_meal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMealBinding = DataBindingUtil.setContentView<ActivityMealBinding>(this, layoutResourceId)
        activityMealBinding.rvMeals.adapter = adapter
        subscribeUi()
    }

    private fun subscribeUi() {
        mealCategoryViewModel.moviesListLiveData.observe(this, Observer {
            adapter.apply { setItems(it) }
        })
    }
}