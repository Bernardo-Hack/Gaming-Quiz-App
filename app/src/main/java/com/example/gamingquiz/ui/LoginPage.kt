package com.example.gamingquiz.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.example.gamingquiz.ui.theme.BackgroundGradient
import com.example.gamingquiz.ui.theme.TextColor

@Composable
fun LoginPage(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(brush = BackgroundGradient),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Box(
            modifier = modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "Bem vindo ao Gaming Quiz",
                modifier = modifier
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                color = TextColor
            )
        }
        Text(
            text = "Insira seu nome para iniciar o jogo.",
            modifier = modifier
                .padding(8.dp)
                .weight(2f, fill = false),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = TextColor
        )


        Column(
            modifier = modifier
                .height(200.dp)
                .fillMaxSize()
                .weight(2f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = { Text("Nome:") },
                modifier = modifier
                    .padding(15.dp)
                    .weight(1f, fill = false)
            )

            FilledTonalButton(
                onClick = { },
                modifier = modifier
                    .weight(2f, fill = false)
            ) {
                Text(
                    text = "Iniciar",
                    modifier = modifier
                        .padding(15.dp),
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