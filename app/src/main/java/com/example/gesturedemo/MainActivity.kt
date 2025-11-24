package com.example.gesturedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gesturedemo.ui.theme.GestureDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestureDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    ScrollModifiers(modifier)
}

@Composable
fun ScrollModifiers(modifier: Modifier = Modifier) {
    val image = ImageBitmap.imageResource(id = R.drawable.maxresdefault)

    Box(modifier = modifier
        .size(150.dp)
        .verticalScroll(rememberScrollState())
        .horizontalScroll(rememberScrollState())) {
        Canvas(
            modifier = Modifier
                .size(360.dp, 270.dp)
        )
        {
            drawImage(
                image = image,
                topLeft = Offset(
                    x = 0f,
                    y = 0f
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GestureDemoTheme {
        MainScreen()
    }
}