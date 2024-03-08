package com.whysoezzy.deliveryapp.ui.screens.auth

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.whysoezzy.deliveryapp.ui.screens.auth.components.SignIn
import com.whysoezzy.deliveryapp.ui.screens.auth.components.SignUp
import com.whysoezzy.deliveryapp.ui.screens.auth.components.TabLayout


@Composable
fun AuthScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("main", Context.MODE_PRIVATE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val selectedTab = remember {
            mutableIntStateOf(0)
        }
        TabLayout(
            selectedIndex = selectedTab.intValue,
            items = listOf(
                "Sign Up" to {
                    SignUp(
                        navController = navController,
                        sharedPref = sharedPref
                    )
                },
                "Sign In" to {
                    SignIn(
                        navController = navController,
                        sharedPref = sharedPref
                    )
                }
            ),
            onTabClick = {
                selectedTab.intValue = it
            }
        )
    }



}