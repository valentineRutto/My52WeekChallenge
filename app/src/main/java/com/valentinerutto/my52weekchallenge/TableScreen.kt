package com.valentinerutto.my52weekchallenge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TableScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "TableScreen")
        val rows = 52
        val columns = 4
        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = rows
        ) {
            val itemModifier = Modifier
                .padding(4.dp)
                .height(80.dp)
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Cyan)
            repeat(rows * columns) {
                Spacer(modifier = itemModifier)
            }
        }
    }
}

@Preview(name = "TableScreen")
@Composable
private fun PreviewTableScreen() {
    TableScreen()
}