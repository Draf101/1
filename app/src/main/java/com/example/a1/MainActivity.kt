package com.example.a1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a1.viewmodels.JokeViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JokeApp()
        }
    }
}

@Composable
fun JokeApp(jokeViewModel: JokeViewModel = viewModel()) {
    val joke = jokeViewModel.joke.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = joke)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { jokeViewModel.fetchJoke() }) {
            Text(text = "Get a Joke")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokeApp()
}