import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.components.FormOutlineComponent
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.dataBase.repository.MatchRepository
import br.com.fiap.mentorandoapp.dataBase.repository.UsuarioRepository
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde4
import br.com.fiap.mentorandoapp.ui.theme.Verde5
import br.com.fiap.mentorandoapp.ui.theme.Verde6

@Composable
fun LoginScreen(
    onLogin: (String, String) -> Unit, // Função de callback para o login
    navController: NavController // NavController para navegação
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)
    val matchRepository = MatchRepository(context)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "LOGIN",
                fontSize = 24.sp,
                color = Verde6,
                fontWeight = FontWeight.Bold, // Adiciona essa linha para tornar o texto em negrito
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            // Campo de Email
            FormOutlineComponent(
                value = email,
                placeholder = "Digite seu email",
                label = "Email",
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Email,
                atualizarValor = { newValue -> email = newValue }
            )

            // Campo de Senha
            FormOutlineComponent(
                value = password,
                placeholder = "Digite sua senha",
                label = "Senha",
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Password,
                atualizarValor = { newValue -> password = newValue }
            )

            // Botão de Login
            Button(
                onClick = {
                    // Chame a função de login passando email e senha
                    var usuario = usuarioRepository.usuarioLogin(email, password)
                    var meus_matchs: List<Int>? = null
                    if (usuario.tipo_usuario == "Aprendiz") {
                        meus_matchs = matchRepository.obterMatchsDoAprendiz(usuario.id)
                    }else {
                        meus_matchs = matchRepository.obterMatchsDoMentor(usuario.id)
                    }

                    Log.d("UsuarioApi", "MEUS MATCH!!!!!: ${meus_matchs.toString()}")



                    LocalStorage.setFilter("usuario_logado", listOf(usuario.id.toString()))
                    LocalStorage.setFilter("meus_matchs", meus_matchs.map{ it.toString()})
                    onLogin(email, password)
                    // Navegue para a próxima tela após o login
                    navController.navigate("BuscaScreen")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(36.dp)
                    .width(250.dp)
                    .shadow(10.dp, shape = RoundedCornerShape(50.dp))
            ) {
                Text(
                    text = "ENTRAR",
                    fontSize = 20.sp,
                    color = Verde1
                )
            }
            // Botão de navegação (Voltar)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(vertical = 8.dp), // Adiciona padding vertical
                horizontalArrangement = Arrangement.Center, // Centraliza o botão
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Voltar",
                    color = Verde6,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .clickable {
                            // Navegue de volta para a tela de cadastro
                            navController.navigate("BemVindoScreen")
                        }
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(onLogin = { _, _ -> /* Callback vazio */ }, navController = navController)
}
