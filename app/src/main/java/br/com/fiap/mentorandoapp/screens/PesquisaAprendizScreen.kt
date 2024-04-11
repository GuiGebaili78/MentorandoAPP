package br.com.fiap.mentorandoapp.screens

import BottomNavigation
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.Api.fetchAprendizFromApi
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde3
import br.com.fiap.mentorandoapp.ui.theme.Verde4
import br.com.fiap.mentorandoapp.ui.theme.Verde5
import br.com.fiap.mentorandoapp.ui.theme.Verde6

@Composable
fun PesquisaAprendizScreen(navController: NavController) {

    var areaAtuacao by remember { mutableStateOf(listOf<String>()) }
    var localizacao by remember { mutableStateOf(listOf<String>()) }
    var disponibilidade by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Verde2), // Altere a cor de fundo aqui
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilterList(
            title = "ÁREA DE ATUAÇÃO",
            items = listOf("Todos") + areaAtuacao,
            onItemsChanged = { areaAtuacao = it },
            color = Color.White
        ) // Altere a cor do filtro aqui
        Spacer(modifier = Modifier.height(8.dp))
        FilterList(
            title = "LOCALIZAÇÃO",
            items = listOf("Todos") + localizacao,
            onItemsChanged = { localizacao = it },
            color = Color.White,


        ) // Altere a cor do filtro aqui
        Spacer(modifier = Modifier.height(8.dp))
        FilterList(
            title = "DISPONIBILIDADE",
            items = listOf("Todos") + disponibilidade,
            onItemsChanged = { disponibilidade = it },
            color = Color.White
        ) // Altere a cor do filtro aqui
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    areaAtuacao = listOf()
                    localizacao = listOf()
                    disponibilidade = listOf()
                },
                colors = ButtonDefaults.buttonColors(Verde6), // Altere a cor de fundo do botão aqui
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(25.dp)) // Adicione a sombra aqui
            ) {
                Text("LIMPAR", color = Verde1) // Altere a cor do texto aqui
            }
            Button(
                onClick = {
                    // Implemente a lógica de aplicação do filtro aqui
                },
                colors = ButtonDefaults.buttonColors(Verde6), // Altere a cor de fundo do botão aqui
                modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(25.dp)) // Adicione a sombra aqui
            ) {
                Text("APLICAR", color = Verde1) // Altere a cor do texto aqui
            }


        }

        BottomNavigation(
            modifier = Modifier.height(56.dp), // Define uma altura fixa para o BottomNavigation
            navController = navController
        )
    }
}

@Composable
fun FilterList(
    title: String,
    items: List<String>,
    onItemsChanged: (List<String>) -> Unit,
    color: Color
) {
    Column {
        Text(
            color = Verde6,
            text = title,
            modifier = Modifier.padding(6.dp),
            style = TextStyle(fontWeight = FontWeight.Bold) // Engrossa o texto
        )
        // Altere a cor do título aqui
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .padding(10.dp)
                .background(Color.White), // Altere a cor de fundo aqui
        ) {
            items(items) { item ->
                CheckboxItem(
                    item = item,
                    selectedItems = items,
                    onItemsChanged = onItemsChanged,
                    color = color
                ) // Passe a cor para o CheckboxItem
            }
        }
    }
}

@Composable
fun CheckboxItem(
    item: String,
    selectedItems: List<String>,
    onItemsChanged: (List<String>) -> Unit,
    color: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (item in selectedItems) {
                    onItemsChanged(selectedItems - item)
                } else {
                    onItemsChanged(selectedItems + item)
                }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item in selectedItems,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(checkedColor = Verde6)
        ) // Altere a cor do checkbox aqui
        Text(
            text = item,
            modifier = Modifier.padding(start = 8.dp),
            color = Verde6
        ) // Altere a cor do texto aqui
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PesquisaAprendizScreenPreview() {
    PesquisaAprendizScreen(navController = rememberNavController())
}
