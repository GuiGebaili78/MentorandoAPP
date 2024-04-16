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
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import br.com.fiap.mentorandoapp.R
import br.com.fiap.mentorandoapp.model.Aprendiz
import br.com.fiap.mentorandoapp.ui.theme.Verde3




@Composable
fun AprendizCard(aprendiz: Aprendiz) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)
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
                text = aprendiz.nome,
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

        AprendizItem(title = "FORMAÇÃO ACADÊMICA", value = aprendiz.formacao)
        AprendizItem(title = "ÁREAS DE INTERESSE", value = aprendiz.interesse)
        AprendizItem(title = "OBJETIVOS", value = aprendiz.objetivo)
        AprendizItem(title = "NÍVEL DE EXPERIÊNCIA", value = aprendiz.experiencia)
        AprendizItem(title = "DISPONIBILIDADE", value = aprendiz.disponibilidade)
        AprendizItem(title = "LOCALIZAÇÃO", value = aprendiz.localizacao)
        AprendizItem(title = "CONTATO", value = aprendiz.contato)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AprendizItem(title: String, value: String) {
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
fun AprendizCardPreview() {
    val sampleAprendiz = Aprendiz(
        id = 1,
        nome = "João",
        formacao = "Formação acadêmica relevante",
        interesse = "Seus interesses na área",
        objetivo = "Objetivos",
        experiencia = "Experiências",
        disponibilidade = "Disponibilidade para mentoria",
        localizacao = "Localização do mentor (opcional)",
        contato = "Meio de contato (e-mail, etc.)",
        tipo_usuario = "aprendiz"
    )

    AprendizCard(aprendiz = sampleAprendiz)
}
