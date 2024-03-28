import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde5

@Composable
fun PerfilAprendizScreen(
    nome: String,
    areasInteresse: String,
    formacaoAcademica: String,
    nivelExperiencia: String,
    objetivosAprendizagem: String,
    disponibilidade: String,
    localizacao: String,
    contato: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(colors = listOf(Verde3, Verde5))),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil",
            fontSize = 28.sp,
            color = Verde1,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        PerfilItem(title = "Nome", value = nome)
        PerfilItem(title = "Áreas de Interesse", value = areasInteresse)
        PerfilItem(title = "Formação Acadêmica", value = formacaoAcademica)
        PerfilItem(title = "Nível de Experiência", value = nivelExperiencia)
        PerfilItem(title = "Objetivos de Aprendizagem", value = objetivosAprendizagem)
        PerfilItem(title = "Disponibilidade", value = disponibilidade)
        PerfilItem(title = "Localização", value = localizacao)
        PerfilItem(title = "Contato", value = contato)
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
            color = Verde1,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Verde1,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilAprendizScreenPreview() {
    PerfilAprendizScreen(
        nome = "João Silva",
        areasInteresse = "Tecnologia, Educação",
        formacaoAcademica = "Bacharel em Ciência da Computação",
        nivelExperiencia = "Avançado",
        objetivosAprendizagem = "Aprender novas tecnologias",
        disponibilidade = "Segunda a Sexta, 8h às 18h",
        localizacao = "São Paulo, Brasil",
        contato = "joao.silva@example.com",
        navController = rememberNavController()
    )
}
