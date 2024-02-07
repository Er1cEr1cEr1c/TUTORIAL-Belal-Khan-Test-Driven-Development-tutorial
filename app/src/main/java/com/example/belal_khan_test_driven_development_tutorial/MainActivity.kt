package com.example.belal_khan_test_driven_development_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belal_khan_test_driven_development_tutorial.ui.theme.BelalKhanTestDrivenDevelopmenttutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelalKhanTestDrivenDevelopmenttutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(text = "Enter Details", color = Color.Black)

        // Spacer
        Spacer(modifier = Modifier.height(16.dp))

        // Amount Input Field
        TextField(
            value = "",
            onValueChange = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .border(border = BorderStroke(1.dp, Color.Gray)),
            placeholder = { Text(text = "Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Spacer
        Spacer(modifier = Modifier.height(16.dp))

        // Description Input Field
        TextField(
            value = "",
            onValueChange = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .border(border = BorderStroke(1.dp, Color.Gray)),
            placeholder = { Text(text = "Description") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        // Spacer
        Spacer(modifier = Modifier.height(16.dp))

        // Button
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BelalKhanTestDrivenDevelopmenttutorialTheme {
        MainScreen()
    }
}