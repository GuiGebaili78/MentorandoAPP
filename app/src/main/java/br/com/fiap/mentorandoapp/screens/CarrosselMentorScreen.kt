package br.com.fiap.mentorandoapp.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Api.fetchMentorsFromApi
import br.com.fiap.mentorandoapp.components.MentorCard
import br.com.fiap.mentorandoapp.model.Mentor
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import br.com.fiap.mentorandoapp.R



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
    ) {
        Column(
            modifier = Modifier.padding(0.2.dp)
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
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentPage = (currentPage - 1 + mentors.size) % mentors.size
                },
                modifier = Modifier.size(60.dp),
                colors = ButtonDefaults.buttonColors(Verde6),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.voltar),
                        contentDescription = "Anterior"
                    )
                }
            )

            Button(
                onClick = {
                    // Lógica para o botão do meio (MATCH)
                },
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(Verde2),
                content = {
                    Text(
                        text = "MATCH",
                        color = Verde6,
                    )
                }
            )

            Button(
                onClick = {
                    currentPage = (currentPage + 1) % mentors.size
                },
                modifier = Modifier.size(60.dp),
                colors = ButtonDefaults.buttonColors(Verde6),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.seguir),
                        contentDescription = "Próximo"
                    )
                }
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarrosselMentorScreenPreview() {
    val navController = rememberNavController()
    CarrosselMentorScreen(navController = navController)
}
