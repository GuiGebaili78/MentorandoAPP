package br.com.fiap.mentorandoapp.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentorandoapp.model.Mentor
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import br.com.fiap.mentorandoapp.R
import br.com.fiap.mentorandoapp.ui.theme.Verde3




@Composable
fun MentorCard(mentor: Mentor) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.80f)
            .padding(4.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .shadow(2.dp, shape = RoundedCornerShape(3.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = mentor.nome,
                fontSize = 24.sp,
                color = Verde6,
                modifier = Modifier
                    .align(Alignment.CenterVertically)

            )

            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "Foto do mentor",
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.Top),
                contentScale = ContentScale.Crop
            )
        }

        MentorItem(title = "FORMAÇÃO ACADÊMICA", value = mentor.formacao)
        MentorItem(title = "ÁREA DE ATUAÇÃO", value = mentor.atuacao)
        MentorItem(title = "CERTIFICAÇÕES", value = mentor.certificacao)
        MentorItem(title = "BIOGRAFIA", value = mentor.biografia)
        MentorItem(title = "DISPONIBILIDADE", value = mentor.disponibilidade)
        MentorItem(title = "LOCALIZAÇÃO", value = mentor.localizacao)
        MentorItem(title = "CONTATO", value = mentor.contato)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun MentorItem(title: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            color = Verde6,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Verde3
        )
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun MentorCardPreview() {
    val sampleMentor = Mentor(
        id = 1,
        nome = "João",
        formacao = "Formação acadêmica relevante",
        atuacao = "Anos de experiência na área",
        certificacao = "Certificações profissionais",
        biografia = "Breve descrição do mentor",
        disponibilidade = "Disponibilidade para mentoria",
        localizacao = "Localização do mentor (opcional)",
        contato = "Meio de contato (e-mail, etc.)"
    )

    MentorCard(mentor = sampleMentor)
}
