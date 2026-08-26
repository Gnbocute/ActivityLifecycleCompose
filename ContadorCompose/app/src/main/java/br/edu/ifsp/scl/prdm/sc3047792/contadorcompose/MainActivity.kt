package br.edu.ifsp.scl.prdm.sc3047792.contadorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.prdm.sc3047792.contadorcompose.ui.theme.ContadorComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContadorScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ContadorScreen(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(0) }
    var initialValue by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            label = { Text(text = "Initial value")},
            modifier = Modifier.fillMaxWidth(),
            value = initialValue.toString(),
            onValueChange = { value ->
                initialValue = value.toIntOrNull() ?: 0
                counter = initialValue
            }
        )
        Text(
            text = counter.toString(),
            fontSize = 48.sp,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {counter++},
        ) {
            Text(text = "Increment")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorScreenPreview() {
    ContadorComposeTheme {
        ContadorScreen(modifier = Modifier)
    }
}