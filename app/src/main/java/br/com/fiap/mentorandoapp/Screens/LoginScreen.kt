import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Components.FormOutlineComponent
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde4
import br.com.fiap.mentorandoapp.ui.theme.Verde5

@Composable
fun LoginScreen(
    onLogin: (String, String) -> Unit, // Função de callback para o login
    navController: NavController // NavController para navegação
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                color = Verde3,
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
                    onLogin(email, password)
                    // Navegue para a próxima tela após o login
                    navController.navigate("MatchScreen")
                },
                colors = ButtonDefaults.buttonColors(Verde5),
                modifier = Modifier
                    .padding(36.dp)
                    .width(250.dp)
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
                    color = Verde4,
                    fontSize = 16.sp,
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
