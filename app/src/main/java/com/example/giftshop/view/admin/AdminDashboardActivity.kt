package com.example.giftshop.view.admin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class AdminDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdminDashboardUI()
        }
    }
}

@Composable
fun AdminDashboardUI() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Welcome Admin 👨‍💼")
    }
}
