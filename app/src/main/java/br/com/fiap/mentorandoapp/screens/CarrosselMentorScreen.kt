package br.com.fiap.mentorandoapp.screens

import BottomNavigation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Api.fetchMentorsFromApi
import br.com.fiap.mentorandoapp.model.Mentor
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import br.com.fiap.mentorandoapp.R
import br.com.fiap.mentorandoapp.components.MentorCard
import br.com.fiap.mentorandoapp.ui.theme.Verde1

@Composable
fun CarrosselMentorScreen(
    navController: NavController
) {
    var mentors by remember { mutableStateOf(emptyList<Mentor>()) }
    var currentPage by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true) {
        mentors = fetchMentorsFromApi()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            mentors.ifEmpty {
                Text(text = "Carregando mentores...")
            }

            mentors.getOrNull(currentPage)?.let { mentor ->
                MentorCard(mentor = mentor)
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentPage = (currentPage - 1 + mentors.size) % mentors.size
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(72.dp)
                    .shadow(4.dp, shape = CircleShape), // Adicionando sombra
                colors = ButtonDefaults.buttonColors(Verde2),
                shape = CircleShape,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.voltar),
                        contentDescription = "Anterior",
                        tint = Verde6,
                        modifier = Modifier.size(32.dp)
                    )
                }
            )

            Button(
                onClick = {
                    // Lógica para o botão do meio (MATCH)
                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                    .height(72.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(16.dp)), // Adicionando sombra
                colors = ButtonDefaults.buttonColors(Verde6),
                shape = RoundedCornerShape(16.dp),
                content = {
                    Text(
                        text = "MATCH",
                        color = Verde1,
                        fontSize = 18.sp
                    )
                }
            )

            Button(
                onClick = {
                    currentPage = (currentPage + 1) % mentors.size
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(72.dp)
                    .shadow(4.dp, shape = CircleShape), // Adicionando sombra
                colors = ButtonDefaults.buttonColors(Verde2),
                shape = CircleShape,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.seguir),
                        contentDescription = "Próximo",
                        tint = Verde6,
                        modifier = Modifier.size(32.dp)
                    )
                }
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigation(navController = navController)
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarrosselMentorScreenPreview() {
    val navController = rememberNavController()
    CarrosselMentorScreen(navController = navController)
}
