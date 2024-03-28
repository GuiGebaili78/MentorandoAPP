package br.com.fiap.mentorandoapp.Screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Components.FormOutlineComponent
import br.com.fiap.mentorandoapp.R
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde5
import androidx.compose.ui.unit.dp as dp1




@Composable
fun CadastroAprendizScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(), // Preenche toda a tela
        verticalArrangement = Arrangement.Center, // Centraliza horizontalmente
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column( // Coluna com scroll vertical
            modifier = Modifier
                .weight(1f) // Ocupa todo o espaço disponível
                .verticalScroll( // Habilita scroll vertical
                    state = rememberScrollState() // Lembra o estado do scroll
                )
        ){

            FormOutlineComponent(
                value = "",
                placeholder = "Digite seu nome",
                label = "Nome",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )

            FormOutlineComponent(
                value = "",
                placeholder = "Tópicos de interesse",
                label = "Áreas de Interesse",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )
            FormOutlineComponent(
                value = "",
                placeholder = "Detalhe sua formação acadêmica",
                label = "Formação Acadêmica",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )
            FormOutlineComponent(
                value = "",
                placeholder = "Nível de experiência atual",
                label = "Nível de Esperiência",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )
            FormOutlineComponent(
                value = "",
                placeholder = "Detalhe seus objetivos",
                label = "Objetivos de Aprendizagem",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )
            FormOutlineComponent(
                value = "",
                placeholder = "Datas e horários disponíveis",
                label = "Disponibilidade",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )
            FormOutlineComponent(
                value = "",
                placeholder = "Localização geográfica",
                label = "Localização",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )

            FormOutlineComponent(
                value = "",
                placeholder = "Digite seus contatos",
                label = "Contato",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {
                    //jurosScreenViewModel.onTempoChanged(it)
                }
            )


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
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        navController.navigate("CadastroScreen")
                    }
            )
        }
    }



}


@Preview (showBackground = true, showSystemUi = true)
@Composable
fun CadastroAprendizScreenPreview() {
    CadastroMentorScreen(navController = rememberNavController())

}