package com.example.tipcalculator

import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.unit.dp
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
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipCalculatorScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TipCalculatorScreen(modifier: Modifier = Modifier) {
    var tipPercent by remember { mutableStateOf(0f) }
    var selectedDiscount by remember { mutableStateOf(3) }
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(text = "Сумма заказа:")

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.width(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Количество блюд:")

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.width(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Чаевые:")

        Slider(
            value = tipPercent,
            onValueChange = { tipPercent = it },
            valueRange = 0f..25f
        )

        Text(text = "${tipPercent.toInt()}%")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Скидка:")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedDiscount == 3,
                onClick = { selectedDiscount = 3 }
            )
            Text(text = "3%")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = selectedDiscount == 5,
                onClick = { selectedDiscount = 5 }
            )
            Text(text = "5%")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = selectedDiscount == 7,
                onClick = { selectedDiscount = 7 }
            )
            Text(text = "7%")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = selectedDiscount == 10,
                onClick = { selectedDiscount = 10 }
            )
            Text(text = "10%")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TipCalculatorPreview() {
    TipCalculatorTheme {
        TipCalculatorScreen()
    }
}