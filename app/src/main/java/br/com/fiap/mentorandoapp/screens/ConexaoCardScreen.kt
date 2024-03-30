package br.com.fiap.mentorandoapp.screens

import BottomNavigation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import br.com.fiap.mentorandoapp.R
import br.com.fiap.mentorandoapp.ui.theme.VerdeSim
import br.com.fiap.mentorandoapp.ui.theme.VermelhoNao

@Composable
fun ConexaoCardScreen(
    nome: String,
    areasInteresse: String,
    formacaoAcademica: String,
    nivelExperiencia: String,
    objetivosAprendizagem: String,
    disponibilidade: String,
    localizacao: String,
    contato: String,
    fotoResId: Int,
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 1.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .verticalScroll(rememberScrollState())
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                .shadow(4.dp, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.75f)
                    .padding(horizontal = 25.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Imagem
                    Image(
                        painter = painterResource(id = fotoResId),
                        contentDescription = "Foto do mentor",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Adiciona espaçamento entre a imagem e o nome

                    // Column para centralizar o nome abaixo da imagem
                    Column(
                        modifier = Modifier
                            .padding(top = 8.dp) // Adiciona padding superior para ajustar a posição vertical
                    ) {
                        Text(
                            text = nome,
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                PerfilConexaoItem(title = "Áreas de Interesse", value = areasInteresse)
                PerfilConexaoItem(title = "Formação Acadêmica", value = formacaoAcademica)
                PerfilConexaoItem(title = "Nível de Experiência", value = nivelExperiencia)
                PerfilConexaoItem(title = "Objetivos de Aprendizagem", value = objetivosAprendizagem)
                PerfilConexaoItem(title = "Disponibilidade", value = disponibilidade)
                PerfilConexaoItem(title = "Localização", value = localizacao)
                PerfilConexaoItem(title = "Contato", value = contato)

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Button(
                onClick = { /* Ação do botão central */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(VermelhoNao),
                content = {
                    Text(
                        text = "NÃO",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            )
            Spacer(modifier = Modifier.width(50.dp))
            Button(
                onClick = { /* Ação do botão central */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(VerdeSim),
                content = {
                    Text(
                        text = "SIM",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))

        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
fun PerfilConexaoItem(title: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            color = Verde3,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Verde6
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConexaoCardScreenPreview() {
    ConexaoCardScreen(
        nome = "José da Silva",
        areasInteresse = "Áreas de Interesse",
        formacaoAcademica = "Formação Acadêmica",
        nivelExperiencia = "Nível de Experiência",
        objetivosAprendizagem = "Objetivos de Aprendizagem",
        disponibilidade = "Disponibilidade",
        localizacao = "Localização",
        contato = "Contato",
        fotoResId = R.drawable.baseline_person_24,
        navController = rememberNavController() // Adicionei rememberNavController() para o preview
    )
}
