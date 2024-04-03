package br.com.fiap.mentorandoapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde4
import br.com.fiap.mentorandoapp.ui.theme.Verde5

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "SELECIONAR",
            color = Verde4,
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Button(
                onClick = {
                    //navController.navigate("")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(36.dp)
                    .width(250.dp)
                    .shadow(10.dp, shape = RoundedCornerShape(50.dp))
            ) {
                Text(
                    text = "MENTOR",
                    fontSize = 20.sp,
                    color = Verde1
                )
            }

            Button(
                onClick = {
                    //navController.navigate("")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(250.dp)
                    .padding(top = 16.dp)
                    .shadow(10.dp, shape = RoundedCornerShape(50.dp))// Adicionando padding entre os botões
            ) {
                Text(
                    text = "APRENDIZ",
                    fontSize = 20.sp,
                    color = Verde1
                )
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center, // Centraliza o botão
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Voltar",
                color = Verde4,
                fontSize = 25.sp,
                modifier = Modifier
                    .clickable {
                        // Navegue de volta para a tela de cadastro
                        navController.navigate("BemVindoScreen")
                    }
            )
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController())
}


