package br.com.fiap.mentorandoapp

import LoginScreen
import PerfilUsuarioScreen
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
import br.com.fiap.mentorandoapp.ui.theme.MentorandoAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorandoApp()
        }
    }
}

@Composable
fun MentorandoApp() {
    MentorandoAPPTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "BemVindoScreen",
                enterTransition = { slideInHorizontally(animationSpec = tween(durationMillis = 100)) }
            ) {
                composable(route = "BemVindoScreen") {
                    BemVindoScreen(navController)
                }
                composable(route = "CadastroUsuarioScreen") {
                    CadastroUsuarioScreen(navController)
                }
                composable(route = "LoginScreen") {
                    LoginScreen(
                        onLogin = { email, password ->
                            navController.navigate("PesquisaUsuarioScreen")
                        },
                        navController = navController
                    )
                }

                composable(route = "CarrosselUsuarioScreen") {
                    CarrosselUsuarioScreen(navController)
                }

                composable(route = "NotificacaoScreen") {
                    NotificacaoScreen(navController)
                }

                composable(route = "PerfilUsuarioScreen") {
                    PerfilUsuarioScreen(
                        nome = "",
                        areasInteresse = "",
                        formacaoAcademica = "",
                        nivelExperiencia = "",
                        objetivos = "",
                        disponibilidade = "",
                        localizacao = "",
                        contato = "",
                        navController = navController
                    )
                }

                composable(route = "MenuScreen") {
                    MenuScreen(navController)
                }
                composable(route = "PesquisaUsuarioScreen") {
                    PesquisaUsuarioScreen(navController)
                }

                composable(route = "BuscaScreen") {
                    BuscaScreen(navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MentorandoAppPreview() {
    MentorandoApp()
}
