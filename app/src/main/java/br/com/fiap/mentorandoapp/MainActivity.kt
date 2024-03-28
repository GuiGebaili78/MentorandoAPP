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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import br.com.fiap.mentorandoapp.Screens.BemVindoScreen
import br.com.fiap.mentorandoapp.ui.theme.MentorandoAPPTheme
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Screens.CadastroAprendizScreen
import br.com.fiap.mentorandoapp.Screens.CadastroMentorScreen
import br.com.fiap.mentorandoapp.Screens.CadastroScreen
import br.com.fiap.mentorandoapp.Screens.MenuScreen
import br.com.fiap.mentorandoapp.Screens.PerfilMentorCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorandoAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "BemVindoScreen", // Defina uma rota válida como startDestination
                        enterTransition = { slideInHorizontally(animationSpec = tween(durationMillis = 200)) }
                    ) {

                        composable(route = "BemVindoScreen") {
                            BemVindoScreen(navController)
                        }
                        composable(route = "LoginScreen") {
                            LoginScreen(
                                onLogin = { email, password ->
                                    navController.navigate("MatchScreen")
                                },
                                navController = navController
                            )
                        }
                        composable(route = "CadastroScreen") {
                            CadastroScreen(navController)
                        }
                        composable(route = "CadastroMentorScreen") {
                            CadastroMentorScreen(navController)
                        }
                        composable(route = "CadastroAprendizScreen") {
                            CadastroAprendizScreen(navController)
                        }
                        composable(route = "PerfilAprendizScreen") {
                            PerfilAprendizScreen(
                                nome = "", // Preencha com os dados do perfil do aprendiz
                                areasInteresse = "",
                                formacaoAcademica = "",
                                nivelExperiencia = "",
                                objetivosAprendizagem = "",
                                disponibilidade = "",
                                localizacao = "",
                                contato = "",
                                navController = navController // Passe o NavController
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

/*

Nome Completo: Campo para o nome completo do mentor.
Experiência: Área onde o mentor pode descrever sua experiência profissional, incluindo cargos anteriores, projetos significativos etc.
Habilidades: Lista de habilidades que o mentor possui e pode oferecer ao aprendiz.
Áreas de Interesse: As áreas nas quais o mentor está interessado em compartilhar conhecimento ou orientar.
Formação Acadêmica: Informações sobre a formação acadêmica do mentor, como instituição, curso, diploma, etc.
Informações Pessoais: Detalhes pessoais opcionais, como hobbies, interesses, etc.
Localização: Localização geográfica do mentor.
Área de Expertise: A área específica em que o mentor é especialista.
Disponibilidade: Horários em que o mentor está disponível para interagir com o aprendiz.
Foto de Perfil: Uma imagem representativa do mentor.
Para o Aprendiz:

Nome Completo: Campo para o nome completo do aprendiz.
Experiência (Opcional): Se o aprendiz já tiver alguma experiência profissional relevante, pode ser incluída aqui.
Habilidades (Opcional): Lista de habilidades que o aprendiz possui ou deseja desenvolver.
Áreas de Interesse: As áreas nas quais o aprendiz está interessado em receber orientação.
Formação Acadêmica: Informações sobre a formação acadêmica do aprendiz, como instituição, curso, diploma, etc.
Informações Pessoais: Detalhes pessoais opcionais, como hobbies, interesses, etc.
Localização: Localização geográfica do aprendiz.
Área de Interesse de Aprendizado: A área específica em que o aprendiz deseja se desenvolver.
Disponibilidade: Horários em que o aprendiz está disponível para interagir com o mentor.
Foto de Perfil: Uma imagem representativa do aprendiz.
Lembre-se de adaptar esses campos conforme necessário para atender às necessidades específicas do seu aplicativo e dos usuários. Além disso, considere a inclusão de campos opcionais para garantir que os usuários tenham flexibilidade ao preencher seus perfis.*/
