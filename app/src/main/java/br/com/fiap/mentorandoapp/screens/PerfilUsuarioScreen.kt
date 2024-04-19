import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde6

@Composable
fun PerfilUsuarioScreen(
    nome: String,
    areasInteresse: String,
    formacaoAcademica: String,
    nivelExperiencia: String,
    objetivos: String,
    disponibilidade: String,
    localizacao: String,
    contato: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f)
            .padding(4.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .shadow(2.dp, shape = RoundedCornerShape(3.dp))

    ) {
        Text(
            text = "Seu Perfil",
            fontSize = 28.sp,
            color = Verde6,
            modifier = Modifier.padding(16.dp)
        )

        PerfilItem(title = "NOME", value = nome)
        PerfilItem(title = "ÁREAS DE INTERESSE", value = areasInteresse)
        PerfilItem(title = "FORMAÇÃO ACADÊMICA", value = formacaoAcademica)
        PerfilItem(title = "NÍVEL DE EXPERIÊNCIA", value = nivelExperiencia)
        PerfilItem(title = "OBJETIVOS", value = objetivos)
        PerfilItem(title = "DISPONIBILIDADE", value = disponibilidade)
        PerfilItem(title = "LOCALIZAÇÃO", value = localizacao)
        PerfilItem(title = "CONTATO", value = contato)

        // Adiciona um espaço flexível para mover o BottomNavigation para o final da tela
        Spacer(modifier = Modifier.weight(1f))

        // BottomNavigation
        BottomNavigation(
            modifier = Modifier.height(56.dp),
            navController = navController
        )
    }
}

@Composable
fun PerfilItem(title: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Verde6,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Verde3,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilUsuarioScreenPreview() {
    PerfilUsuarioScreen(
        nome = "João Silva",
        areasInteresse = "Tecnologia, Educação",
        formacaoAcademica = "Bacharel em Ciência da Computação",
        nivelExperiencia = "Avançado",
        objetivos = "Aprender novas tecnologias",
        disponibilidade = "Segunda a Sexta, 8h às 18h",
        localizacao = "São Paulo, Brasil",
        contato = "joao.silva@example.com",
        navController = rememberNavController()
    )
}
