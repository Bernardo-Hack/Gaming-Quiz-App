package com.example.gamingquiz.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamingquiz.R
import com.example.gamingquiz.ui.theme.AppBackgroundColor
import com.example.gamingquiz.ui.theme.TextColor

@Composable
fun QuestionCard(modifier: Modifier = Modifier, questionText: String, imageUrl: Int) {
    Box(
        modifier = modifier
            .background(color = AppBackgroundColor)
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = questionText,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = TextColor
            )

            Image(
                painter = painterResource(id = imageUrl),
                contentDescription = "Question Image",
                modifier = modifier,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    QuestionCard(questionText = "What company does this logo belong to?", imageUrl = R.drawable.john_doe)
}
