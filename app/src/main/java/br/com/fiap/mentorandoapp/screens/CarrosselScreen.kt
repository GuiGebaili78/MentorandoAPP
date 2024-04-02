package br.com.fiap.mentorandoapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mentorandoapp.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde4
import br.com.fiap.mentorandoapp.ui.theme.Verde6
import br.com.fiap.mentorandoapp.ui.theme.VerdeSim


@Composable
fun CarrosselScreen(
    navController: NavController
) {
    val animals = listOf(
        R.drawable.cat,
        R.drawable.dog,
        R.drawable.chicken,
    )

    var currentPage by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyRow(
            modifier = Modifier.weight(0.85f)
        ) {
            itemsIndexed(animals) { index, animal ->
                ItemCarousel(animal = animal, currentPage = currentPage, index = index)
            }
        }

        Row(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    currentPage = (currentPage - 1 + animals.size) % animals.size
                },
                modifier = Modifier.size(60.dp),
                colors = ButtonDefaults.buttonColors(Verde6),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "Anterior"
                    )
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    // Lógica para o botão do meio (MATCH)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp)
                    .height(60.dp), // Alterado para 60.dp para aumentar a altura
                colors = ButtonDefaults.buttonColors(Verde2),
                content = {
                    Text(
                        text = "MATCH",
                        textAlign = TextAlign.Center,
                        color = Verde6,
                        style = TextStyle(fontSize = 20.sp),
                        fontWeight = FontWeight.Bold// Altere o tamanho do texto aqui
                    )
                }
            )


            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    currentPage = (currentPage + 1) % animals.size
                },
                modifier = Modifier.size(60.dp),
                colors = ButtonDefaults.buttonColors(Verde6),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "Próximo"
                    )
                }
            )
        }




    }
}

@Composable
fun ItemCarousel(animal: Int, currentPage: Int, index: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (index == currentPage) {
            Image(
                painter = painterResource(id = animal),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Preview (showBackground = true, showSystemUi = true)
@Composable
fun CarrosselScreenPreview() {
    val navController = rememberNavController()
    CarrosselScreen(navController = navController)
}
