package com.example.dgarciafinanceapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun FinanceSummaryCard(
    title:String,
    amount:String,
    color:Color,
    modifier: Modifier = Modifier
){

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color),
            contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(title)
                Text(amount, fontWeight = FontWeight.Bold)
            }
        }
    }
}