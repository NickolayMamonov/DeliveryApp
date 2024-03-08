package com.whysoezzy.deliveryapp.ui.screens.auth.components

import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.whysoezzy.deliveryapp.R

@Composable
fun SignUp(
    navController: NavController,
    sharedPref: SharedPreferences
) {
    val rememberMeChecked = remember {
        mutableStateOf(false)
    }
    val email = remember {
        mutableStateOf("")
    }
    val pass = remember {
        mutableStateOf("")
    }
    val passRepeat = remember {
        mutableStateOf("")
    }
    val showPass = remember {
        mutableStateOf(false)
    }
    val showPassRepeat = remember {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(22.dp))
        CustomTextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            label = "Email"
        ) {

        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            value = pass.value,
            onValueChange = {
                pass.value = it
            },
            label = "Password",
            visualTransformation = if (showPass.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailing = {
                Icon(
                    modifier = Modifier.clickable {
                        showPass.value = !showPass.value
                    },
                    painter = painterResource(
                        id = if (showPass.value) {
                            R.drawable.ic_eye_off
                        } else {
                            R.drawable.ic_eye_open
                        }
                    ),
                    contentDescription = null

                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            value = passRepeat.value,
            onValueChange = {
                passRepeat.value = it
            },
            label = "Password",
            visualTransformation = if (showPass.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailing = {
                Icon(
                    modifier = Modifier.clickable {
                        showPassRepeat.value = !showPassRepeat.value
                    },
                    painter = painterResource(
                        id = if (showPass.value) {
                            R.drawable.ic_eye_off
                        } else {
                            R.drawable.ic_eye_open
                        }
                    ),
                    contentDescription = null

                )
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = {
                sharedPref.edit().apply {
                    putBoolean("loggedIn", true)
                    putString("email", email.value)
                }.apply()
                navController.navigate("home") {
                    popUpTo(0)
                }
            },
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Register")
        }


    }


}