package com.expeknow.day2_monflow.ui.bottomsNav

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.expeknow.day2_monflow.R

@Composable
fun BottomMenu() {
    val menuItem = listOf(
        BottomNavMenu.User,
        BottomNavMenu.Wallet,
        BottomNavMenu.Home,
        BottomNavMenu.Notification,
        BottomNavMenu.Settings
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.bottom_nav_bg),
        modifier = Modifier.clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp))
    ){

        menuItem.forEach {
            BottomNavigationItem(selected = it.route == "home", onClick = {  },
                icon = {
                    Icon(imageVector = it.icon, contentDescription = it.title)
                       },
                selectedContentColor = colorResource(id = R.color.saving_spending_card_bg),
                unselectedContentColor = Color.Gray,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BottomMenu()
}