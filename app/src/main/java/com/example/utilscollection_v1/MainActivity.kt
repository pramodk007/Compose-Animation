package com.example.utilscollection_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.utilscollection_v1.ui.theme.UtilsCollectionv1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtilsCollectionv1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnimateViewCrossFade()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UtilsCollectionv1Theme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateViewOne() {

    var state by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        AnimatedVisibility(visible = state) {
            SampleComposable()
        }

        Button(
            onClick = { state = !state },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text(text = "toggle")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateViewTwo() {

    var state by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        AnimatedVisibility(
            visible = state,
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            SampleComposable()
        }

        Button(
            onClick = { state = !state },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text(text = "toggle")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateViewThree() {

    var state by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        AnimatedVisibility(
            visible = state,
            enter = expandHorizontally() + fadeIn(),
            exit = shrinkHorizontally() + fadeOut()
        ) {
            SampleComposable()
        }

        Button(
            onClick = { state = !state },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text(text = "toggle")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateViewCrossFade() {

    var state by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Crossfade(targetState = state) { state ->
            if (state) {
                SampleComposable()
            } else {
                SampleComposableB()
            }
        }

        Button(
            onClick = { state = !state },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text(text = "toggle")
        }
    }
}

@Composable
fun SampleComposable() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Red)
    ) {
        Text(text = "Box A", modifier = Modifier.align(Alignment.Center))
    }
}
@Composable
fun SampleComposableB() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Yellow)
    ) {
        Text(text = "Box B", modifier = Modifier.align(Alignment.Center))
    }
}
