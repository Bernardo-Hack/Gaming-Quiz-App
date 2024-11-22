package com.example.gamingquiz.ui.components.questions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gamingquiz.R

@Composable
fun QuestionPanel(
    question: String,
    imgUrl: String
) {
    val context = LocalContext.current
    val drawableId = remember(imgUrl) {
        context.resources.getIdentifier(
            imgUrl,
            "drawable",
            context.packageName
        )
    }

    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = question,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = drawableId),
                contentDescription = "Question Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
