package com.example.gamingquiz.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamingquiz.ui.theme.LightBackgroundColor
import com.example.gamingquiz.ui.theme.PrimaryColor
import com.example.gamingquiz.ui.theme.TextColor

@Composable
fun AnswerButton(btnText: Array<String>, modifier: Modifier = Modifier) {

    val btnModifier = Modifier
        .padding(8.dp)

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 150.dp),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(btnText.size) { index ->
            Box(
                modifier = modifier
                    .background(color = LightBackgroundColor)
                    .padding(8.dp),
                contentAlignment = Alignment.Center,
                propagateMinConstraints = false

            ) {
                TextButton(
                    onClick = { println("placeholder") },
                    modifier = btnModifier
                ) {
                    Text(
                        text = btnText[index],
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = TextColor
                    )
                }
            }
            VerticalDivider(color = PrimaryColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentPreview() {
    val btnNames = arrayOf("Answer 1", "Answer 2", "Answer 3", "Answer 4")
    AnswerButton(btnText = btnNames)
}