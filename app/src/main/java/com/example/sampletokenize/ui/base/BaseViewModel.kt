package com.example.sampletokenize.ui.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {

    // Allows view model to control navigation
    lateinit var navController: NavController
}
