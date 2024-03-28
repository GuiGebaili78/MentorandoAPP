package br.com.fiap.mentorandoapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.fiap.mentorandoapp.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde4
import br.com.fiap.mentorandoapp.ui.theme.Verde5
import br.com.fiap.mentorandoapp.ui.theme.Verde6




@Composable
fun BemVindoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nome do aplicativo
        Text(
            text = "MENTORANDO",
            textAlign = TextAlign.Center,
            fontSize = 32.sp, // Tamanho de fonte maior para torná-lo mais chamativo
            fontWeight = FontWeight.Bold, // Definindo a fonte como negrito para torná-lo mais grosso
            color = Verde4,
            modifier = Modifier.padding(bottom = 46.dp)
        )

        // Imagem central
        Image(
            painter = painterResource(R.drawable.mulher_aprendiz),
            contentDescription = "Logo do aplicativo",
            modifier = Modifier
                .size(200.dp)
                .padding(20.dp)
                .clip(RectangleShape),
            contentScale = ContentScale.Fit
        )

        // Botão "SEGUIR"
        Button(
            onClick = {
                //navController.navigate("")
            },
            colors = ButtonDefaults.buttonColors(Verde5),
            modifier = Modifier
                .padding(horizontal = 16.dp)

                .width(250.dp)
        ) {
            Text(
                text = "COMEÇAR",
                fontSize = 20.sp,
                color = Verde1
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BemVindoScreenPreview() {
    BemVindoScreen()
}


