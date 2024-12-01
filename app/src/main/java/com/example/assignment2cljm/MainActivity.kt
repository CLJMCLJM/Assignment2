package com.example.assignment2cljm

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.core.content.ContextCompat
import com.example.assignment2cljm.ui.theme.Assignment2CLJMTheme

class MainActivity : ComponentActivity() {
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Log.d("Permission", "Permission granted")
                setContent {
                    MainContent()
                }
            } else {
                Log.d("Permission", "Permission denied")
                setContent {
                    PermissionDeniedContent()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d("Permission", "onCreate called")

        when {
            ContextCompat.checkSelfPermission(this, "com.example.assignment2cljm.MSE412") == PackageManager.PERMISSION_GRANTED -> {
                Log.d("Permission", "Permission already granted")
                setContent {
                    MainContent()
                }
            }
            shouldShowRequestPermissionRationale("com.example.assignment2cljm.MSE412") -> {
                Log.d("Permission", "Should show rationale for permission")
                requestPermissionLauncher.launch("com.example.assignment2cljm.MSE412")
            }
            else -> {
                Log.d("Permission", "Requesting permission directly")
                requestPermissionLauncher.launch("com.example.assignment2cljm.MSE412")
            }
        }
    }

    @Composable
    fun MainContent() {
        Assignment2CLJMTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    StudentInfo(
                        modifier = Modifier.padding(4.dp)
                    ) {
                        val explicitIntent = Intent(this@MainActivity, MainActivity2::class.java)
                        startActivity(explicitIntent)
                    }
                    ImplicitButton(
                        modifier = Modifier.padding(4.dp)
                    ) {
                        val implicitIntent = Intent("com.example.assignment2cljm.ACTION_VIEW")
                        startActivity(implicitIntent)
                    }
                    Activity3Button(
                        modifier = Modifier.padding(4.dp)
                    ) {
                        val explicitIntent = Intent(this@MainActivity, MainActivity3::class.java)
                        startActivity(explicitIntent)
                    }
                }
            }
        }
    }

    @Composable
    fun PermissionDeniedContent() {
        Assignment2CLJMTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Permission Denied. Please grant permissions to proceed.")
                }
            }
        }
    }
}

@Composable
fun StudentInfo(modifier: Modifier = Modifier, onExplicitButtonClick: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)) {
        Text(text = "Connor Johnson-Mork", fontSize = 50.sp, lineHeight = 56.sp, textAlign = TextAlign.Center)
        Text(text = "1358941", fontSize = 30.sp, lineHeight = 8.sp, modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterHorizontally))
        Button(onClick = onExplicitButtonClick, Modifier.padding(16.dp).align(alignment = Alignment.CenterHorizontally)) {
            Text(text = "Start Activity Explicitly")
        }
    }
}

@Composable
fun ImplicitButton(modifier: Modifier = Modifier, onImplicitButtonClick: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)){
        Button(onClick = onImplicitButtonClick, Modifier.padding(16.dp)) {
            Text(text = "Start Activity Implicitly")
        }
    }
}

@Composable
fun Activity3Button(modifier: Modifier = Modifier, onActivity3ButtonClick: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)){
        Button(onClick = onActivity3ButtonClick, Modifier.padding(16.dp)) {
            Text(text = "View Image Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameAndIDPreview() {
    Assignment2CLJMTheme {
        StudentInfo(onExplicitButtonClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    Assignment2CLJMTheme {
        ImplicitButton(onImplicitButtonClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun Activity3Preview() {
    Assignment2CLJMTheme {
        Activity3Button(onActivity3ButtonClick = {})
    }
}
