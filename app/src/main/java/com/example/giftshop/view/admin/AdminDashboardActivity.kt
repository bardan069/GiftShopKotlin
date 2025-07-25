package com.example.giftshop.view.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giftshop.R
import com.example.giftshop.ui.theme.GiftShopTheme

import com.example.giftshop.view.DashboardActivity

class AdminDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiftShopTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AdminDashboardUI()
                }
            }
        }
    }
}

@Composable
fun AdminDashboardUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Admin Dashboard 👨‍💼",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        AdminCard(
            title = "Add Product",
            imageRes = R.drawable.ic_add,
            onClick = { /* navigate */ }
        )

        AdminCard(
            title = "Update Product",
            imageRes = R.drawable.ic_edit,
            onClick = { /* navigate */ }
        )

        AdminCard(
            title = "View Users",
            imageRes = R.drawable.ic_users,
            onClick = { /* navigate */ }
        )
    }
}

@Composable
fun AdminCard(title: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
