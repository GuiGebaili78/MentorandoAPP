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
import br.com.fiap.mentorandoapp.model.UsuarioModel
import br.com.fiap.mentorandoapp.ui.theme.Verde3




@Composable
fun UsuarioCard(usuarioModel: UsuarioModel) {
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
                text = usuarioModel.nome,
                fontSize = 24.sp,
                color = Verde6,
                modifier = Modifier
                    .align(Alignment.CenterVertically)

            )

            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "Foto do usuário",
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.Top),
                contentScale = ContentScale.Crop
            )
        }

        UsuarioItem(title = "FORMAÇÃO ACADÊMICA", value = usuarioModel.formacao)
        UsuarioItem(title = "ÁREAS DE INTERESSE", value = usuarioModel.interesse)
        UsuarioItem(title = "OBJETIVOS", value = usuarioModel.objetivo)
        UsuarioItem(title = "EXPERIÊNCIA", value = usuarioModel.experiencia)
        UsuarioItem(title = "DISPONIBILIDADE", value = usuarioModel.disponibilidade)
        UsuarioItem(title = "LOCALIZAÇÃO", value = usuarioModel.localizacao)
        UsuarioItem(title = "CONTATO", value = usuarioModel.contato)


        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun UsuarioItem(title: String, value: String) {
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
fun UsuarioCardPreview() {
    val sampleUsuario = UsuarioModel(
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

    UsuarioCard(usuarioModel = sampleUsuario)
}
