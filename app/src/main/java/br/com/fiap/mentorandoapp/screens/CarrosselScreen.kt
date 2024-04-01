package br.com.fiap.mentorandoapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mentorandoapp.R
import androidx.compose.runtime.mutableStateOf


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
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentPage = (currentPage - 1 + animals.size) % animals.size
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Red),
                content = { Text(text = "ANTERIOR") }
            )
            Button(
                onClick = {
                    currentPage = (currentPage + 1) % animals.size
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(),
                content = { Text(text = "PRÓXIMO") }
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
