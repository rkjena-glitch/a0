package com.example.assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment0.ui.theme.Assignment0Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var clickCount by remember { mutableStateOf(0) }  // click Counter, mutableStateOf means we can change the value, remember tells compose to remember
            var output by remember { mutableStateOf("Should we go") }  // The output given by the buttons each time after being pressed, Yes or No
            Assignment0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)  // Using padding created by Scaffold
                    ) {
                        Text(output)  // Output, will change
                        Row {
                            Button1(  // Three arguments passed down
                                name = "1/2",
                                onClick = {  // What to do after clicked
                                    clickCount++  // Click count increases
                                    val randomNumberGenerated = Random.nextInt(1, 101)  // Random number from 1 to 101
                                    if (randomNumberGenerated <= 50) {
                                        output = "Yes"
                                    } else {
                                        output = "No"
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)  // variable modifier calling built in Modifier for padding
                            )

                            Button2(
                                name = "1/4",
                                onClick = {
                                    clickCount++
                                    val randomNumberGenerated = Random.nextInt(1, 101)

                                    if (randomNumberGenerated <= 25) {
                                        output = "Yes"
                                    } else {
                                        output = "No"
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            )

                            Button3(
                                name = "1/10",
                                onClick = {
                                    clickCount++
                                    val randomNumberGenerated = Random.nextInt(1, 101)

                                    if (randomNumberGenerated <= 10) {
                                        output = "Yes"
                                    } else {
                                        output = "No"
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                        Text("click count: $clickCount")  // Click count updates each time
                        Text("CCID: rkjena")  // CCID
                        Text("Student ID: 1863103")  // Student ID
                    }
                }
            }
        }
    }
}

@Composable
fun Button1(name: String, onClick: () -> Unit, modifier: Modifier = Modifier)  {  // Button1 function has 3 parameters, onClick provides what to do when clicked and returns nothing, modifier of type Modifier = empty Modifier
    Button(  // The built in onClick and modifier for the button
        onClick = onClick,
        modifier = modifier
    ) {
        Text(name)
    }
}

@Composable
fun Button2(name: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(name)
    }
}

@Composable
fun Button3(name: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(name)
    }
}