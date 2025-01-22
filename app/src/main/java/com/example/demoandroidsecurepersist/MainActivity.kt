package com.example.demoandroidsecurepersist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.demoandroidsecurepersist.screens.libcounter.LibCounterScreen
import com.example.demoandroidsecurepersist.ui.theme.DemoAndroidSecurePersistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAndroidSecurePersistTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LibCounterScreen()
                }
            }
        }
    }
}
