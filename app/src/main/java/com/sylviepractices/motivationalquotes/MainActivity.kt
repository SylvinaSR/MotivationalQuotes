package com.sylviepractices.motivationalquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sylviepractices.motivationalquotes.ui.quote.QuoteViewModel
import com.sylviepractices.motivationalquotes.ui.theme.MotivationalQuotesTheme
import com.sylviepractices.motivationalquotes.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()
            MotivationalQuotesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = White
                ) { innerPadding ->
                    NavigationWrapper(
                        modifier = Modifier.padding(innerPadding),
                        navHostController = navHostController,
                        quoteViewModel = quoteViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MotivationalQuotesTheme {
        Greeting("Android")
    }
}