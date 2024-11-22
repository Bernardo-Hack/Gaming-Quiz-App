package com.example.gamingquiz.ui.components.questions

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamingquiz.data.model.Question
import com.example.gamingquiz.ui.theme.AppTheme

@Composable
fun AnswerPanel(
    options: List<String>,
    onAnswerSelected: (Int) -> Unit,
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        state = rememberLazyGridState(),
    ) {
        items(options.size) { index ->
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .border(1.dp, MaterialTheme.colorScheme.onSurface)
                    .padding(vertical = 25.dp),
                contentAlignment = Alignment.Center,
                propagateMinConstraints = true

            ) {
                TextButton(
                    onClick = { onAnswerSelected(index) },
                    shape = MaterialTheme.shapes.large,
                ) {
                    Text(
                        text = options[index],
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
