package br.com.fiap.mentorandoapp.components



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentorandoapp.model.Mentor

@Composable
fun MentorCard(mentor: Mentor) {
    // Modificador para definir o espaçamento interno do cartão
    val cardModifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(color = Color.White) // Cor de fundo branca

    // Modificador para o conteúdo do cartão
    val contentModifier = Modifier.padding(16.dp)

    Column(
        modifier = cardModifier
    ) {
        Column(
            modifier = contentModifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = mentor.nome, fontSize = 20.sp)
            Text(text = mentor.formacao)
            Text(text = mentor.experiencia)
            Text(text = mentor.certificacao)
            Text(text = mentor.biografia)
            Text(text = mentor.disponibilidade)
            Text(text = mentor.localizacao)
            Text(text = mentor.contato)
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun MentorCardPreview() {
    // Crie um objeto Mentor de exemplo com valor para 'id'
    val sampleMentor = Mentor(
        id = 1, // Insira o ID real se necessário
        nome = "Exemplo de Mentor",
        formacao = "Formação acadêmica relevante",
        experiencia = "Anos de experiência na área",
        certificacao = "Certificações profissionais",
        biografia = "Breve descrição do mentor",
        disponibilidade = "Disponibilidade para mentoria",
        localizacao = "Localização do mentor (opcional)",
        contato = "Meio de contato (e-mail, etc.)"
    )

    MentorCard(mentor = sampleMentor)
}
