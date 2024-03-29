package br.com.fiap.mentorandoapp

import LoginScreen
import PerfilAprendizScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.screens.*
import androidx.compose.material3.Text // Adicionando import para Text
import br.com.fiap.mentorandoapp.ui.theme.MentorandoAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorandoAPPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "BemVindoScreen",
                        enterTransition = { slideInHorizontally(animationSpec = tween(durationMillis = 200)) }
                    ) {
                        composable(route = "BemVindoScreen") {
                            BemVindoScreen(navController)
                        }
                        composable(route = "LoginScreen") {
                            LoginScreen(
                                onLogin = { email, password ->
                                    navController.navigate("ConexaoCardScreen")
                                },
                                navController = navController
                            )
                        }
                        composable(route = "CadastroScreen") {
                            CadastroScreen(navController)
                        }
                        composable(route = "NotificacaoScreen") {
                            NotificacaoScreen(navController)
                        }
                        composable(route = "CadastroMentorScreen") {
                            CadastroMentorScreen(navController)
                        }
                        composable(route = "CadastroAprendizScreen") {
                            CadastroAprendizScreen(navController)
                        }
                        composable(route = "PerfilAprendizScreen") {
                            PerfilAprendizScreen(
                                nome = "",
                                areasInteresse = "",
                                formacaoAcademica = "",
                                nivelExperiencia = "",
                                objetivosAprendizagem = "",
                                disponibilidade = "",
                                localizacao = "",
                                contato = "",
                                navController = navController
                            )
                        }
                        composable(route = "PerfilMentorScreen") {
                            PerfilMentorCard(
                                nome = "Nome do Mentor",
                                areasInteresse = "Áreas de Interesse do Mentor",
                                formacaoAcademica = "Formação Acadêmica do Mentor",
                                nivelExperiencia = "Nível de Experiência do Mentor",
                                objetivosAprendizagem = "Objetivos de Aprendizagem do Mentor",
                                disponibilidade = "Disponibilidade do Mentor",
                                localizacao = "Localização do Mentor",
                                contato = "Contato do Mentor",
                                fotoResId = R.drawable.baseline_person_24,
                                navController = navController
                            )
                        }
                        composable(route = "MenuScreen") {
                            MenuScreen(navController)
                        }
                        composable(route = "ConexaoCardScreen") {
                            ConexaoCardScreen(
                                nome = "Nome do Mentor ou Aprendiz",
                                areasInteresse = "Áreas de Interesse",
                                formacaoAcademica = "Formação Acadêmica",
                                nivelExperiencia = "Nível de Experiência",
                                objetivosAprendizagem = "Objetivos de Aprendizagem",
                                disponibilidade = "Disponibilidade",
                                localizacao = "Localização",
                                contato = "Contato",
                                fotoResId = R.drawable.baseline_person_24,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MentorandoApp() {
    Text(text = "Bem Vindo Mentorando")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MentorandoAppPreview() {
    MentorandoApp()
}
