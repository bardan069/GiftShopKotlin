package com.example.giftshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.giftshop.navigation.NavigationActivity
import com.example.giftshop.ui.theme.GiftShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GiftShopTheme {
                    NavigationActivity()
            }
        }
    }
}
