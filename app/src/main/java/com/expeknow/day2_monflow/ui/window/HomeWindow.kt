package com.expeknow.day2_monflow.ui.window

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.expeknow.day2_monflow.R
import com.expeknow.day2_monflow.ui.bottomsNav.BottomMenu
import com.expeknow.day2_monflow.ui.bottomsNav.BottomNavMenu
import com.expeknow.day2_monflow.ui.theme.poppings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeWindow(modifier : Modifier = Modifier) {

    val scrollState = rememberScrollState()

    Scaffold( bottomBar = { BottomMenu() } ) {
        Column(Modifier.padding(it).verticalScroll(scrollState)) {
            TopBar()

            //balance text
            Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 30.dp, end=30.dp, top=20.dp)) {
                Text(text = "$",
                fontSize = 30.sp,
                fontFamily = poppings)
                Text(text = "590.85",
                fontSize = 60.sp,
                fontFamily = poppings
                )
            }

            //current balance row
            Row(modifier=modifier) {
                Text(text = "Current Balance", fontSize = 25.sp,
                    modifier = Modifier.weight(1f),
                fontFamily = poppings, fontWeight = FontWeight.SemiBold)
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.more_horiz),
                        contentDescription = "")
                }
            }

            //Daily income and spending cards
            SpendingSavingsCard(modifier)

            //transections history
            Text(text = "Transection history", fontSize = 25.sp,
                modifier = modifier.padding(top = 15.dp), fontFamily = poppings,
                fontWeight = FontWeight.SemiBold)

            Column {
                repeat(10){
                    TransectionHistoryRowItem(name = "Atul", date = "10 Feb 2022", time = "03:34AM",
                        transferAmount = 350.0f, isSent = true)
                    TransectionHistoryRowItem(name = "Aman", date = "12 Feb 2022", time = "04:34PM",
                        transferAmount = 3400.0f, isSent = false)
                }
            }



        }
    }
}

@Composable
fun TransectionHistoryRowItem(name: String, date: String, time: String, transferAmount: Float,
    isSent: Boolean){
    Row(Modifier.padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically) {
        Card(shape = RoundedCornerShape(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = if(isSent) R.color.outgoing_icon_bg else R.color.incoming_icon_bg)
            ), modifier = Modifier.padding(10.dp)
        ) {
            Icon(painter = painterResource(id = if(isSent) R.drawable.outgoing else R.drawable.incoming),
                contentDescription = "icon indicating direction of transfer",
                modifier = Modifier.padding(15.dp),
                tint = Color.White)
        }

        val nameText = if(isSent) "To" else "From"
        Column (Modifier.weight(1f)) {
            Text(text = "$nameText $name", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "$date at $time", fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
            color = Color.LightGray)
        }
        val sign = if (isSent) "-" else "+"
        Text(text = "${sign}$${transferAmount}", fontSize = 18.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp))
    }
}


@Composable
fun SpendingSavingsCard(modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .padding(horizontal = 15.dp)
        .height(220.dp)) {

        Card(shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.saving_spending_card_bg)
            ),
            modifier = Modifier
                .padding(5.dp)
                .weight(1f)
                .fillMaxHeight()) {

            CardContents(
                cardTitle = "Daily Income",
                spendingPercentage = 34,
                dollars = 1993,
                isSpendings = false,
                cents = 93
            )
        }

        Card(shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.saving_spending_card_bg)
            ),
            modifier = Modifier
                .padding(5.dp)
                .weight(1f)
                .fillMaxHeight()) {

            CardContents(
                cardTitle = "Spending",
                spendingPercentage = 23,
                dollars = 53422,
                isSpendings = true,
                cents = 34
            )
        }

    }
}


@Composable
fun CardContents(cardTitle: String, spendingPercentage: Int, dollars: Int,
                 isSpendings: Boolean, cents : Int, ) {

    Column() {
        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = cardTitle, fontSize = 12.sp,
                color = Color.White, modifier = Modifier.weight(1f))

            Icon(painter = painterResource(id = R.drawable.more_horiz),
                contentDescription = "", tint = Color.White,
                modifier = Modifier.size(16.dp))

        }

        if(!isSpendings)
            Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                Text(text = "$spendingPercentage%",
                    fontSize = 45.sp, fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.balace_amout_purple_gray))
            }

        Row(modifier = Modifier
            .padding(5.dp)
            .weight(1f)) {
            Card(shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxSize(),

            ) {
                if(isSpendings)
                    Text(text = "$spendingPercentage%",
                    fontSize = 45.sp, fontWeight = FontWeight.SemiBold,
                    color = Color.LightGray,
                    fontFamily = poppings,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp))



                Column(verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)) {
                    Text(text = if (isSpendings) "Spending" else "My Balance", fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )

                    Row() {
                        Text(text = "$ ${dollars}.", fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black)
                        Text(text = cents.toString(), fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray)
                    }
                }
            }
        }

    }


}


@Composable
fun TopBar() {
    
    Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.monflow_logo),
            contentDescription = "logo",
            modifier = Modifier.size(50.dp))

        Text(text = "MONFLOW",
            Modifier.weight(1f).padding(5.dp),
            fontSize = 18.sp,
            fontFamily = poppings,
            fontWeight = FontWeight.Bold)

        Button(onClick = { /*TODO*/ },
        shape = RoundedCornerShape(15.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.profile_card_background_yellow)
        ), modifier = Modifier.size(50.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "",
                Modifier.size(40.dp))
        }

    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeWindow(Modifier.padding(horizontal = 30.dp, vertical = 10.dp))
}


