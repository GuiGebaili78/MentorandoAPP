package br.com.fiap.mentorandoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.components.FormOutlineComponent
import br.com.fiap.mentorandoapp.dataBase.repository.UsuarioRepository
import br.com.fiap.mentorandoapp.model.UsuarioModel
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

@Composable
fun CadastroUsuarioScreen(navController: NavController) {

    val nomeState = remember {
        mutableStateOf("")
    }
    val interesseState = remember {
        mutableStateOf("")
    }
    val formacaoState = remember {
        mutableStateOf("")
    }
    val experienciaState = remember {
        mutableStateOf("")
    }
    val objetivoState = remember {
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
    val tipoUsuarioState = remember {
        mutableStateOf("Aprendiz") // Inicializa como Aprendiz por padrão
    }

    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(
                    state = rememberScrollState()
                )
        ){
            Text(
                text = "Cadastro de Usuários",
                fontSize = 24.sp,
                color = Verde6,
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
                    .padding(16.dp),
                keyboardType = KeyboardType.Text,
                atualizarValor = { novoValor ->
                    nomeState.value = novoValor
                }
            )


            FormOutlineComponent(
                value = interesseState.value,
                placeholder = "Tópicos de interesse",
                label = "Áreas de Interesse",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    interesseState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = formacaoState.value,
                placeholder = "Detalhe sua formação acadêmica",
                label = "Formação Acadêmica",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    formacaoState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = experienciaState.value,
                placeholder = "Experiência nas áreas",
                label = "Experiência",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    experienciaState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = objetivoState.value,
                placeholder = "Detalhe seus objetivos",
                label = "Objetivos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    objetivoState.value = novoValor
                }
            )
            FormOutlineComponent(
                value = disponibilidadeState.value,
                placeholder = "Datas e horários disponíveis",
                label = "Disponibilidade",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
                    .padding(16.dp),
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
                    .padding(16.dp),
                keyboardType = KeyboardType.Text,
                atualizarValor = {novoValor ->
                    contatoState.value = novoValor
                }
            )

            // Adicione os outros componentes de formulário aqui

            // Checkbox para selecionar o tipo de usuário (Mentor ou Aprendiz)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = tipoUsuarioState.value == "Mentor",
                    onCheckedChange = { checked ->
                        if (checked) {
                            tipoUsuarioState.value = "Mentor"
                        } else {
                            tipoUsuarioState.value = "Aprendiz"
                        }
                    },
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "Mentor")
                Spacer(modifier = Modifier.width(16.dp))
                Checkbox(
                    checked = tipoUsuarioState.value == "Aprendiz",
                    onCheckedChange = { checked ->
                        if (checked) {
                            tipoUsuarioState.value = "Aprendiz"
                        } else {
                            tipoUsuarioState.value = "Mentor"
                        }
                    },
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "Aprendiz")
            }


        }

        // Botão de navegação
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Verde2),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Espaçamento entre os elementos
        ) {
            Text(
                text = "Voltar",
                color = Verde6,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        navController.navigate("LoginScreen")
                    }
            )
            Text(
                text = "Cadastrar",
                color = Verde6,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable {
                        val usuario = UsuarioModel(
                            nome = nomeState.value,
                            interesse = interesseState.value,
                            formacao = formacaoState.value,
                            experiencia = experienciaState.value,
                            objetivo = objetivoState.value,
                            disponibilidade = disponibilidadeState.value,
                            localizacao = localizacaoState.value,
                            contato = contatoState.value,
                            tipo_usuario = tipoUsuarioState.value // Usa o tipo de usuário selecionado
                        )
                        usuarioRepository.salvar(usuario)

                        // Limpa os campos após o cadastro ser realizado com sucesso
                        nomeState.value = ""
                        interesseState.value = ""
                        formacaoState.value = ""
                        experienciaState.value = ""
                        objetivoState.value = ""
                        disponibilidadeState.value = ""
                        localizacaoState.value = ""
                        contatoState.value = ""
                        tipoUsuarioState.value = "Aprendiz" // Reinicializa o tipo de usuário para Aprendiz
                    }
            )
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun CadastroUsuarioScreenPreview() {
    CadastroUsuarioScreen(navController = rememberNavController())
}