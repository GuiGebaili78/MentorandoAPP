package br.com.fiap.mentorandoapp.screens

import BottomNavigation
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Api.fetchUsuarioFromApi
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PesquisaUsuarioScreen(navController: NavController) {
    var interesse by remember { mutableStateOf(listOf<String>()) }
    var localizacao by remember { mutableStateOf(listOf<String>()) }
    var disponibilidade by remember { mutableStateOf(listOf<String>()) }

    var interesseSelecionada by remember { mutableStateOf(listOf<String>()) }
    var localizacaoSelecionada by remember { mutableStateOf(listOf<String>()) }
    var disponibilidadeSelecionada by remember { mutableStateOf(listOf<String>()) }

    // Função para carregar dados da API e atualizar os filtros
    fun carregarDadosDaApi() {
        CoroutineScope(Dispatchers.Main).launch {
            val usuarios = fetchUsuarioFromApi()
            interesse = usuarios.map { it.interesse }.distinct()
            localizacao = usuarios.map { it.localizacao }.distinct()
            disponibilidade = usuarios.map { it.disponibilidade }.distinct()
        }
    }

    // Carregar dados da API sempre que a tela for aberta
    LaunchedEffect(Unit) {
        carregarDadosDaApi()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Verde2), // Altere a cor de fundo aqui
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilterList(
            title = "ÁREA DE INTERESSE",
            items = interesse,
            selectedItems = interesseSelecionada,
            onItemsChanged = { interesseSelecionada = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        FilterList(
            title = "LOCALIZAÇÃO",
            items = localizacao,
            selectedItems = localizacaoSelecionada,
            onItemsChanged = { localizacaoSelecionada = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        FilterList(
            title = "DISPONIBILIDADE",
            items = disponibilidade,
            selectedItems = disponibilidadeSelecionada,
            onItemsChanged = { disponibilidadeSelecionada = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // Limpar os filtros selecionados
                    interesseSelecionada = listOf()
                    localizacaoSelecionada = listOf()
                    disponibilidadeSelecionada = listOf()
                    LocalStorage.setFilter("interesse", interesseSelecionada)
                    LocalStorage.setFilter("localizacao", localizacaoSelecionada)
                    LocalStorage.setFilter("disponibilidade", disponibilidadeSelecionada)
                    navController.navigate("CarrosselUsuarioScreen")
                },
                colors = ButtonDefaults.buttonColors(Verde6),
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(25.dp))
            ) {
                Text("LIMPAR", color = Verde1)
            }
            Button(
                onClick = {
                    // Definindo um filtro na chave 'interesse'
                    LocalStorage.setFilter("interesse", interesseSelecionada)
                    LocalStorage.setFilter("localizacao", localizacaoSelecionada)
                    LocalStorage.setFilter("disponibilidade", disponibilidadeSelecionada)
                    navController.navigate("CarrosselUsuarioScreen")


                },
                colors = ButtonDefaults.buttonColors(Verde6),
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(25.dp))
            ) {
                Text("APLICAR", color = Verde1)
            }
        }
        BottomNavigation(
            modifier = Modifier.height(56.dp),
            navController = navController
        )
    }
}



@Composable
fun FilterList(
    title: String,
    items: List<String>,
    selectedItems: List<String>,
    onItemsChanged: (List<String>) -> Unit
) {
    Column {
        Text(
            color = Verde6,
            text = title,
            modifier = Modifier.padding(6.dp),
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .padding(10.dp)
                .background(Color.White),
        ) {
            items(items) { item ->
                CheckboxItem(
                    item = item,
                    selectedItems = selectedItems,
                    onItemsChanged = onItemsChanged
                )
            }
        }
    }
}

@Composable
fun CheckboxItem(
    item: String,
    selectedItems: List<String>,
    onItemsChanged: (List<String>) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val updatedItems = if (item in selectedItems) {
                    selectedItems - item
                } else {
                    selectedItems + item
                }
                onItemsChanged(updatedItems)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item in selectedItems,
            onCheckedChange = { isChecked ->
                val updatedItems = if (isChecked) {
                    selectedItems + item
                } else {
                    selectedItems - item
                }
                onItemsChanged(updatedItems)
            },
            colors = CheckboxDefaults.colors(checkedColor = Verde6)
        )
        Text(
            text = item,
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PesquisaUsuarioScreenPreview() {
    PesquisaUsuarioScreen(navController = rememberNavController())
}
