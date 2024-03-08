package com.whysoezzy.deliveryapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.whysoezzy.deliveryapp.R
import com.whysoezzy.deliveryapp.ui.screens.auth.components.TabLayout
import com.whysoezzy.deliveryapp.ui.screens.home.components.Foods

val foods = listOf(
    Food(
        name = "Meal 1",
        image = R.drawable.meal_1,
        type = FoodType.Meal
    ),
    Food(
        name = "Meal 2",
        image = R.drawable.meal_2,
        type = FoodType.Meal
    ),
    Food(
        name = "Meal 3",
        image = R.drawable.meal_3,
        type = FoodType.Meal
    ),
    Food(
        name = "Meal 4",
        image = R.drawable.meal_4,
        type = FoodType.Meal
    ),
    Food(
        name = "Meal 5",
        image = R.drawable.meal_5,
        type = FoodType.Meal
    ),
    Food(
        name = "Meal 6",
        image = R.drawable.meal_6,
        type = FoodType.Meal
    ),
    Food(
        name = "Side 1",
        image = R.drawable.sides_1,
        type = FoodType.Side
    ),
    Food(
        name = "Side 2",
        image = R.drawable.sides_2,
        type = FoodType.Side
    ),
    Food(
        name = "Side 3",
        image = R.drawable.sides_3,
        type = FoodType.Side
    ),
    Food(
        name = "Side 4",
        image = R.drawable.sides_4,
        type = FoodType.Side
    ),
    Food(
        name = "Side 5",
        image = R.drawable.sides_5,
        type = FoodType.Side
    ),
    Food(
        name = "Side 6",
        image = R.drawable.sides_6,
        type = FoodType.Side
    ),
    Food(
        name = "Snack 1",
        image = R.drawable.snacks_1,
        type = FoodType.Snack
    ),
    Food(
        name = "Snack 2",
        image = R.drawable.snacks_2,
        type = FoodType.Snack
    ),
    Food(
        name = "Snack 3",
        image = R.drawable.snacks_3,
        type = FoodType.Snack
    ),
    Food(
        name = "Snack 4",
        image = R.drawable.snacks_4,
        type = FoodType.Snack
    ),
    Food(
        name = "Snack 5",
        image = R.drawable.snacks_5,
        type = FoodType.Snack
    ),
    Food(
        name = "Snack 6",
        image = R.drawable.snacks_6,
        type = FoodType.Snack
    )
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val uiController = rememberSystemUiController()
    uiController.isStatusBarVisible = false
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Menu")
            },
            navigationIcon = {
                Row {
                    Spacer(modifier = Modifier.height(8.dp))
                    Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                }
            })
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            val selectedFoodType = remember {
                mutableIntStateOf(0)
            }
            val foodsState = remember {
                mutableStateListOf(*(foods + foods).toTypedArray())
            }
            val onLikeChange: (Food) -> Unit = {
                foodsState[foodsState.indexOf(it)] =
                    foodsState[foodsState.indexOf(it)].copy(liked = !it.liked)
            }
            Spacer(modifier = Modifier.height(16.dp))
            TabLayout(items = listOf(
                "Meals" to {
                    Foods(
                        items = foodsState.filter { it.type == FoodType.Meal },
                        onLikeChange = onLikeChange,
                        onTap = {
                            navController.navigate("food")
                        }
                    )
                },
                "Sides" to {
                    Foods(
                        items = foodsState.filter { it.type == FoodType.Side },
                        onLikeChange = onLikeChange,
                        onTap = {
                            navController.navigate("food")
                        }
                    )
                },
                "Snacks" to {
                    Foods(
                        items = foodsState.filter { it.type == FoodType.Snack },
                        onLikeChange = onLikeChange,
                        onTap = {
                            navController.navigate("food")
                        }
                    )
                }
            ),
                selectedIndex = selectedFoodType.intValue,
                onTabClick = {
                    selectedFoodType.intValue = it
                },
                textHeight = 30.dp,
                indicatorPadding = PaddingValues(horizontal = 10.dp)
            )

        }

    }
}