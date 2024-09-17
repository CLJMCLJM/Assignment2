package com.example.assignment2cljm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2cljm.ui.theme.Assignment2CLJMTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2CLJMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Challenges(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        val explicitIntent = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(explicitIntent)
                    }
                }
            }
        }
    }
}

@Composable
fun Challenges(modifier: Modifier = Modifier, onExplicitButtonClick: () -> Unit) {

    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)) {
        Text(text = "1) Device Fragmentation", fontSize = 20.sp, lineHeight = 26.sp, textAlign = TextAlign.Center)
        Text(text = "2) OS Fragmentation", fontSize = 20.sp, lineHeight = 26.sp, textAlign = TextAlign.Center)
        Text(text = "3) Unstable and Dynamic Environment", fontSize = 20.sp, lineHeight = 26.sp, textAlign = TextAlign.Center)
        Text(text = "4) Low Consumer Tolerance", fontSize = 20.sp, lineHeight = 26.sp, textAlign = TextAlign.Center)
        Text(text = "5) Low Security", fontSize = 20.sp, lineHeight = 26.sp, textAlign = TextAlign.Center)
        Button(onClick = onExplicitButtonClick, Modifier.padding(16.dp).align(alignment = Alignment.CenterHorizontally)) {
            Text(text = "Main Activity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengesPreview() {
    Assignment2CLJMTheme {
        Challenges(onExplicitButtonClick = {})
    }
}
