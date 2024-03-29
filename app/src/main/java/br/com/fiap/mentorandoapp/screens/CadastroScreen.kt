package br.com.fiap.mentorandoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde5

@Composable
fun CadastroScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Column(
            modifier = Modifier.weight(1f), // Ajusta dinamicamente ao conteúdo da tela
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Texto "Cadastre-se"
            Text(
                text = "Cadastre-se",
                fontSize = 24.sp,
                color = Verde3,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = {
                    navController.navigate("CadastroMentorScreen")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(36.dp)
                    .width(250.dp)
            ) {
                Text(
                    text = "MENTOR",
                    fontSize = 20.sp,
                    color = Verde1
                )
            }

            Button(
                onClick = {
                    navController.navigate("CadastroAprendizScreen")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(250.dp)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "APRENDIZ",
                    fontSize = 20.sp,
                    color = Verde1
                )
            }
        }

        // Botão de navegação
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Brush.linearGradient(colors = listOf(Verde3, Verde5))),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Voltar",
                color = Verde1,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        navController.navigate("BemVindoScreen")
                    }
            )
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CadastroScreenPreview() {
    CadastroScreen(navController = rememberNavController())
}
