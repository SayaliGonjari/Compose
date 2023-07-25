package com.plcoding.navigationdrawercompose.presentation.navigations

import com.plcoding.navigationdrawercompose.R

sealed class DrawerScreens(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: Int
) {
    object Home : DrawerScreens("Home","Home","Go to home screen", R.drawable.baseline_home_24)
    object Settings : DrawerScreens("settings","Settings","Go to settings screen", R.drawable.baseline_settings_24)
    object Profile : DrawerScreens("Profile","Profile","Go to profile", R.drawable.baseline_person_24)
    object Login : DrawerScreens("Login","Login","Login", R.drawable.baseline_login_24)
}