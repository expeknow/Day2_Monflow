package com.expeknow.day2_monflow.ui.bottomsNav

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavMenu (
    val route : String,
    val icon : ImageVector,
    val title: String
) {

    object User : BottomNavMenu("user", Icons.Rounded.Person, "Profile")
    object Wallet : BottomNavMenu("wallet", Icons.Rounded.CheckCircle, "Wallet")
    object Home : BottomNavMenu("home", Icons.Rounded.Home, "Home")
    object Notification : BottomNavMenu("notification", Icons.Rounded.Notifications, "Notifications")
    object Settings : BottomNavMenu("settings", Icons.Rounded.Settings, "Settings")

}
