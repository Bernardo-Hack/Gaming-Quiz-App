package com.example.gamingquiz.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamingquiz.ui.theme.TextColor

@Composable
fun LoginPage(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem vindo ao Gaming Quiz",
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 45.sp,
            color = TextColor
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(10.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = { Text("Nome:") },
                modifier = modifier
                    .padding(15.dp)
            )

            FilledTonalButton(
                onClick = { },
                modifier = modifier
            ) {
                Text(
                    text = "Bem vindo ao Gaming Quiz",
                    modifier = modifier
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                )
            }
        }
    }

}

@Preview
@Composable
fun LoginPreview() {
    LoginPage()
}