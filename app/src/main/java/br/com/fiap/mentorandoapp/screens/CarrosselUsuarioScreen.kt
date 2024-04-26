package br.com.fiap.mentorandoapp.screens

import BottomNavigation
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Api.fetchUsuariosFromDb
import br.com.fiap.mentorandoapp.Api.filtrarUsuario
import br.com.fiap.mentorandoapp.R
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.components.UsuarioCard
import br.com.fiap.mentorandoapp.dataBase.repository.MatchRepository
import br.com.fiap.mentorandoapp.dataBase.repository.UsuarioRepository
import br.com.fiap.mentorandoapp.model.MatchModel
import br.com.fiap.mentorandoapp.model.UsuarioModel
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde5
import br.com.fiap.mentorandoapp.ui.theme.Verde6

@Composable
fun CarrosselUsuarioScreen(
    navController: NavController,
    context: Context // Adicione o contexto como parâmetro
) {
    var usuarios by remember { mutableStateOf(emptyList<UsuarioModel>()) }
    var currentPage by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val matchRepository = MatchRepository(context)

    LaunchedEffect(key1 = true) {
        val usuariosFromDb = fetchUsuariosFromDb(context) // Use o contexto fornecido
        val usuariosFiltrados = filtrarUsuario(usuariosFromDb)
        usuarios = usuariosFiltrados
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.2.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (usuarios.isEmpty()) {
                Text(text = "Nenhum usuario encontrado")
            } else {
                UsuarioCard(usuarioModel = usuarios[currentPage])
            }
        }
        Button(
            onClick = {
                navController.navigate("PesquisaUsuarioScreen")
            },
            colors = ButtonDefaults.buttonColors(Verde5),
            modifier = Modifier
                .padding(2.dp)
                .align(Alignment.CenterHorizontally)
                .width(140.dp)
                .shadow(10.dp, shape = RoundedCornerShape(50.dp))
        ) {
            Text(
                text = "Pesquisar",
                fontSize = 18.sp,
                color = Verde1
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentPage = (currentPage - 1 + usuarios.size) % usuarios.size
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(72.dp)
                    .shadow(4.dp, shape = CircleShape),
                colors = ButtonDefaults.buttonColors(Verde2),
                shape = CircleShape,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.voltar),
                        contentDescription = "Anterior",
                        tint = Verde6,
                        modifier = Modifier.size(32.dp)
                    )
                }
            )
            Button(
                onClick = {
                    // Lógica para o botão do meio (MATCH)
                    val tipo_usuario = LocalStorage.getFilter("tipo_usuario")!![0]
                    var usuario_id = usuarios[currentPage].id
                    var meu_id = LocalStorage.getFilter("usuario_logado")!![0].toInt()
                    var match: MatchModel? = null
                    var novo_match: MatchModel? = null

                    if (tipo_usuario == "Mentor") {
                        match = matchRepository.buscarMatchAprendiz(meu_id, usuario_id)
                        if (match == null) {
                            novo_match = MatchModel(
                                aprendiz_id = meu_id,
                                mentor_id = usuario_id,
                                aprendiz_liked = true,
                                mentor_liked = false
                            )
                            matchRepository.salvar(novo_match)
                        }

                    }else {
                        match = matchRepository.buscarMatchMentor(meu_id, usuario_id)
                        if (match == null) {
                            novo_match = MatchModel(
                                aprendiz_id = usuario_id,
                                mentor_id = meu_id,
                                aprendiz_liked = false,
                                mentor_liked = true
                            )
                            matchRepository.salvar(novo_match)
                        }

                    }

                    if (match != null) {
                        Log.d("UsuarioApi", "DEU MATCH!!!!!: ${match.toString()}")
                    }



                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                    .height(72.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(Verde6),
                shape = RoundedCornerShape(16.dp),
                content = {
                    Text(
                        text = "MATCH",
                        color = Verde1,
                        fontSize = 28.sp
                    )
                }
            )
            Button(
                onClick = {
                    currentPage = (currentPage + 1) % usuarios.size
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(72.dp)
                    .shadow(4.dp, shape = CircleShape),
                colors = ButtonDefaults.buttonColors(Verde2),
                shape = CircleShape,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.seguir),
                        contentDescription = "Próximo",
                        tint = Verde6,
                        modifier = Modifier.size(32.dp)
                    )
                }
            )
        }
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            BottomNavigation(navController = navController)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarrosselUsuarioScreenPreview() {
    val navController = rememberNavController()
    val context = LocalContext.current // Obtenha o contexto local
    CarrosselUsuarioScreen(navController = navController, context = context)
}
