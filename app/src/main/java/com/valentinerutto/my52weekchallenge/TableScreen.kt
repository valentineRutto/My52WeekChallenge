package com.valentinerutto.my52weekchallenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TableScreen(
) {
    var startingAmount by remember { mutableStateOf(50) }
    var weeksList by remember { mutableStateOf(generateSavingsList(startingAmount)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextField(value = startingAmount.toString(), onValueChange = { newValue ->
            startingAmount = newValue.toIntOrNull() ?: 50
            weeksList = generateSavingsList(startingAmount)
        }, label = { Text("Enter starting amount (Ksh)") }, modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Savings per Week", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        // Display the list of savings
        LazyColumn {
            items(weeksList.size) { index ->
                val (week, amount) = weeksList[index]
                Text(
                    text = "Week $week: Ksh. $amount", modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

fun generateSavingsList(startAmount: Int): List<Pair<Int, Int>> {
    return (1..52).map { week ->
        week to startAmount * week
    }
}

@Preview(name = "TableScreen")
@Composable
private fun PreviewTableScreen() {
    TableScreen()
}