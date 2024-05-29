package tw.edu.pu.s1092181.a5_29

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.s1092181.a5_29.ui.theme._5_29Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _5_29Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LazyColumn {
        // Add a single item
        item {
            Text(text = "Header")
        }

        // Add 3 items
        items(51) { index ->
            Text(text = "First List items : $index")
        }

        // Add 2 items
        items(2) { index ->
            Text(text = "Second List Items: $index")
        }

        // Add another single item
        item {
            Text(text = "Footer")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _5_29Theme {
        Greeting("Android")
    }
}