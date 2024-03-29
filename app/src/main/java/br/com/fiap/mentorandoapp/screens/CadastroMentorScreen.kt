package br.com.fiap.mentorandoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.components.FormOutlineComponent
import br.com.fiap.mentorandoapp.dataBase.repository.AprendizRepository
import br.com.fiap.mentorandoapp.dataBase.repository.MentorRepository
import br.com.fiap.mentorandoapp.model.AprendizModel
import br.com.fiap.mentorandoapp.model.MentorModel
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde5
import androidx.compose.ui.unit.dp as dp1


@Composable
fun CadastroMentorScreen(navController: NavController) {

    val nomeState = remember {
        mutableStateOf("")
    }
    val formacaoState = remember {
        mutableStateOf("")
    }
    val experienciaState = remember {
        mutableStateOf("")
    }
    val certificacaoState = remember {
        mutableStateOf("")
    }
    val biografiaState = remember {
        mutableStateOf("")
    }
    val disponibilidadeState = remember {
        mutableStateOf("")
    }
    val localizacaoState = remember {
        mutableStateOf("")
    }
    val contatoState = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val mentorRepository = MentorRepository(context)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column( // Coluna com scroll vertical
            modifier = Modifier
                .weight(1f)
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            Text(
                text = "Cadastro de Mentores",
                fontSize = 24.sp,
                color = Verde3,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)

            )

            FormOutlineComponent(
                value = nomeState.value,
                placeholder = "Digite seu nome",
                label = "Nome",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = { novoValor ->
                    nomeState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = experienciaState.value,
                placeholder = "Detalhe sua experiência",
                label = "Experiência profissional",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    experienciaState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = formacaoState.value,
                placeholder = "Detalhe sua formação acadêmica",
                label = "Formação Acadêmica",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    formacaoState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = certificacaoState.value,
                placeholder = "Certificações profissionais ou acadêmicas",
                label = "Certificações",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    certificacaoState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = biografiaState.value,
                placeholder = "Breve biografia",
                label = "Biografia",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    biografiaState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = disponibilidadeState.value,
                placeholder = "Datas e horários disponíveis",
                label = "Disponibilidade",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    disponibilidadeState.value = novoValor

                }
            )
            FormOutlineComponent(
                value = localizacaoState.value,
                placeholder = "Localização geográfica",
                label = "Localização",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    localizacaoState.value = novoValor
                }
            )

            FormOutlineComponent(
                value = contatoState.value,
                placeholder = "Digite seus contatos",
                label = "Contato",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp1),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    contatoState.value = novoValor
                }
            )


        }
        // Botão de navegação
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Brush.linearGradient(colors = listOf(Verde3, Verde5))),
            horizontalArrangement = Arrangement.SpaceBetween, // Espaça os itens uniformemente
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Voltar",
                color = Verde1,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        navController.navigate("CadastroScreen")
                    }
            )
            Text(
                text = "Cadastrar",
                color = Verde1,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable {
                        val mentor = MentorModel(
                            nome = nomeState.value,
                            formacao = formacaoState.value,
                            experiencia = experienciaState.value,
                            certificacao = certificacaoState.value,
                            biografia = biografiaState.value,
                            disponibilidade = disponibilidadeState.value,
                            localizacao = localizacaoState.value,
                            contato = contatoState.value
                        )
                        mentorRepository.salvar(mentor)

                        // Limpa os campos após o cadastro ser realizado com sucesso
                        nomeState.value = ""
                        formacaoState.value = ""
                        experienciaState.value = ""
                        certificacaoState.value = ""
                        biografiaState.value = ""
                        disponibilidadeState.value = ""
                        localizacaoState.value = ""
                        contatoState.value = ""

                    }
            )
        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CadastroMentorScreenPreview() {
    CadastroMentorScreen(navController = rememberNavController())

}