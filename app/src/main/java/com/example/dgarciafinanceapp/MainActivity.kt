package com.example.dgarciafinanceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dgarciafinanceapp.ui.theme.DGarciaFinanceAppTheme
import com.example.dgarciafinanceapp.components.FinanceSummaryCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DGarciaFinanceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(innerPadding)
                }
            }
        }
    }
}


data class User(
    val name: String,
    val balance: Double
)



val user = User("Diego", 280.99)


@Composable
fun HomeScreen(innerPadding: PaddingValues){

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

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color(0xFFE7D7C9), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color.Black, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Person, null, tint = Color(0xFFE7D7C9))
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text("Hola ${user.name}", fontWeight = FontWeight.Bold)
                        Text("Bienvenido")
                    }
                }

                IconButton(onClick = {}) {
                    Icon(Icons.Default.Menu, null)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}