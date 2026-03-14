package com.example.dgarciafinanceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dgarciafinanceapp.components.FinanceSummaryCard
import com.example.dgarciafinanceapp.ui.theme.DGarciaFinanceAppTheme
import com.example.dgarciafinanceapp.components.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            DGarciaFinanceAppTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen()
                }
            }
        }
    }
}
data class User(
    val name: String,
    val balance: Double
)
data class SummaryCard(
    val title: String,
    val amount: String,
    val color: Color
)

data class Transaction(
    val store: String,
    val category: String,
    val amount: Double,
    val time: String
)


val user = User("Diego", 280.99)
val transactions = listOf(
    Transaction("Supermarket", "Groceries", 45.99, "10:30 AM"),
    Transaction("Gas Station", "Fuel", -30.5, "12:15 PM"),
    Transaction("Coffee Shop", "Food & Drinks", 5.75, "8:00 AM"),
    Transaction("Electronics Store", "Electronics", 120.0, "3:45 PM"),
    Transaction("Bookstore", "Books", 25.99, "2:00 PM"),
    Transaction("Restaurant", "Dining", 60.0, "7:30 PM")
)
@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color(0xFFE7D7C9), shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color.Black, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                tint = Color(0xFFE7D7C9),
                                contentDescription = "Usuario"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Hola ${user.name}",
                            fontWeight = FontWeight.Bold
                        )
                        Text("Bienvenido")
                    }
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                FinanceSummaryCard(
                    title = "Actividad",
                    amount = "de la Semana",
                    color = Color(0xFFDDE8E4),
                    icon = Icons.Default.Face,
                    modifier = Modifier
                        .weight(1f)
                        .height(200.dp)
                )

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    SummaryCardItem(
                        title = "Ventas",
                        amount = "$280.99",
                        color = Color(0xFFE7D7C9),
                        modifier = Modifier.height(95.dp)
                    )

                    SummaryCardItem(
                        title = "Ganancias",
                        amount = "$280.99",
                        color = Color(0xFFD9D3F0),
                        modifier = Modifier.height(95.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Transactions",
                    fontWeight = FontWeight.Bold
                )

                Text("See All")
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        items(transactions) { transaction ->
            TransactionCard(transaction)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    DGarciaFinanceAppTheme {
        HomeScreen()
    }
}