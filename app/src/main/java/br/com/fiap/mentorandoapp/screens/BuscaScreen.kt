package br.com.fiap.mentorandoapp.screens

import BottomNavigation
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde5
import br.com.fiap.mentorandoapp.ui.theme.Verde6

@Composable
fun BuscaScreen(navController: NavController) {
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
                text = "Estou buscando por:",
                fontSize = 18.sp,
                color = Verde6,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = {
                    LocalStorage.setFilter("tipo_usuario", listOf("Mentor"))
                    navController.navigate("CarrosselUsuarioScreen")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(36.dp)
                    .width(250.dp)
                    .shadow(10.dp, shape = RoundedCornerShape(50.dp))
            ) {
                Text(
                    text = "MENTORES",
                    fontSize = 20.sp,
                    color = Verde1
                )
            }

            Button(
                onClick = {
                    LocalStorage.setFilter("tipo_usuario", listOf("Aprendiz"))
                    navController.navigate("CarrosselUsuarioScreen")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(250.dp)
                    .padding(top = 16.dp)
                    .shadow(10.dp, shape = RoundedCornerShape(50.dp))
            ) {
                Text(
                    text = "APRENDIZES",
                    fontSize = 20.sp,
                    color = Verde1
                )
            }
        }

        // Botão de navegação

            BottomNavigation(navController = navController)
        }
    }





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BuscaScreenPreview() {
    BuscaScreen(navController = rememberNavController())
}
