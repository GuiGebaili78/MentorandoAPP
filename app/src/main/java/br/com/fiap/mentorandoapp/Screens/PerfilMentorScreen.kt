package br.com.fiap.mentorandoapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.ui.theme.*
import br.com.fiap.mentorandoapp.R

@Composable
fun PerfilMentorCard(
    nome: String,
    areasInteresse: String,
    formacaoAcademica: String,
    nivelExperiencia: String,
    objetivosAprendizagem: String,
    disponibilidade: String,
    localizacao: String,
    contato: String,
    navController: NavController,
    fotoResId: Int // Recurso de ID da imagem
) {
    Row {
        Text(
            text = "Texto",
            fontSize = 20.sp,
            color = Verde6,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Texto",
            fontSize = 20.sp,
            color = Verde6,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Perfil",
                fontSize = 24.sp,
                color = Verde6,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Image(
                painter = painterResource(id = fotoResId),
                contentDescription = "Foto do mentor",
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.Top),
                contentScale = ContentScale.Crop
            )
        }

        PerfilItem(title = "Nome", value = nome)
        PerfilItem(title = "Áreas de Interesse", value = areasInteresse)
        PerfilItem(title = "Formação Acadêmica", value = formacaoAcademica)
        PerfilItem(title = "Nível de Experiência", value = nivelExperiencia)
        PerfilItem(title = "Objetivos de Aprendizagem", value = objetivosAprendizagem)
        PerfilItem(title = "Disponibilidade", value = disponibilidade)
        PerfilItem(title = "Localização", value = localizacao)
        PerfilItem(title = "Contato", value = contato)

        Spacer(modifier = Modifier.height(16.dp))



    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /* TODO: Ação do botão esquerdo */ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White // Cor do conteúdo (texto ou ícone) do botão esquerdo
            )
        ) {
            // Ícone ou texto do botão esquerdo
        }
        Spacer(modifier = Modifier.width(8.dp)) // Espaço entre os botões
        Button(
            onClick = { /* Ação do botão central */ },
            modifier = Modifier
                .weight(1f)
                .background(Verde2),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White // Cor do conteúdo (texto ou ícone) do botão central
            ),
            content = {
                Text(
                    text = "MATCH",
                    fontWeight = FontWeight.Bold, // Texto em negrito
                    fontSize = 16.sp // Tamanho da fonte
                )
            }
        )
        Spacer(modifier = Modifier
            .width(8.dp)) // Espaço entre os botões
        Button(
            onClick = { /* TODO: Ação do botão direito */ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White // Cor do conteúdo (texto ou ícone) do botão direito
            )
        ) {
            // Ícone ou texto do botão direito
        }
    }
}

@Composable
fun PerfilItem(title: String, value: String) {
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
fun PerfilMentorCardPreview() {
    PerfilMentorCard(
        nome = "João Silva",
        areasInteresse = "Tecnologia, Educação",
        formacaoAcademica = "Bacharel em Ciência da Computação",
        nivelExperiencia = "Avançado",
        objetivosAprendizagem = "Aprender novas tecnologias",
        disponibilidade = "Segunda a Sexta, 8h às 18h",
        localizacao = "São Paulo, Brasil",
        contato = "joao.silva@example.com",
        navController = rememberNavController(),
        fotoResId = R.drawable.baseline_person_24 // Substitua pelo ID do recurso da foto
    )
}
