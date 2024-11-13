package com.example.gamingquiz.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamingquiz.ui.theme.C4lr

@Composable
fun AnswerPanel(
    btnText: List<String>,
    onAnswerSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {

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
                    .background(MaterialTheme.colorScheme.surface)
                    .border(1.dp, MaterialTheme.colorScheme.onSurface)
                    .padding(8.dp),
                contentAlignment = Alignment.Center,
                propagateMinConstraints = true

            ) {
                TextButton(
                    onClick = { onAnswerSelected(btnText[index]) },
                    modifier = btnModifier
                ) {
                    Text(
                        text = btnText[index],
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentPreview() {
    val btnNames = listOf("Answer 1", "Answer 2", "Answer 3", "Answer 4")
    AnswerPanel(btnText = btnNames, onAnswerSelected = {})
}