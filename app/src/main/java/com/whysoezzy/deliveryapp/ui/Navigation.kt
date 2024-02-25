package com.whysoezzy.deliveryapp.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import com.whysoezzy.deliveryapp.ui.screens.AuthScreen
import com.whysoezzy.deliveryapp.ui.screens.FoodScreen
import com.whysoezzy.deliveryapp.ui.screens.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("main", Context.MODE_PRIVATE)
    val userLoggedIn = sharedPref.getBoolean("loggedIn",false)
    NavHost(navController = navController, startDestination = if(userLoggedIn) "main" else "auth" ){
        composable("auth"){
            AuthScreen(navController = navController)
        }
        composable("main"){
            HomeScreen(navController = navController)
        }
        composable("food"){
            FoodScreen(navController = navController)
        }

    }
}
