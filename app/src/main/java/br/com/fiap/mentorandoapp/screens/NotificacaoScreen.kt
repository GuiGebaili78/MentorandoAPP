package br.com.fiap.mentorandoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.components.BottomNavigation
import br.com.fiap.mentorandoapp.components.LocalStorage
import br.com.fiap.mentorandoapp.dataBase.repository.MatchRepository
import br.com.fiap.mentorandoapp.dataBase.repository.NotificationRepository
import br.com.fiap.mentorandoapp.ui.theme.Verde1
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import br.com.fiap.mentorandoapp.ui.theme.Verde4


@Composable
fun NotificacaoScreen(
    onClose: () -> Unit,
    navController: NavController
) {

    val context = LocalContext.current
    val notificationRepository = NotificationRepository(context)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Verde1)
                .verticalScroll(rememberScrollState()), // Adicionando scroll vertical
            verticalArrangement = Arrangement.Top
        ) {
            var meu_id = LocalStorage.getFilter("usuario_logado")!![0].toInt()
            var notifications = notificationRepository.listarNotificacoes(meu_id)

            notifications.forEach { notification ->
                NotificacaoItem(
                    message = notification.nome + " Contato: " + notification.contato,
                    onClose = onClose
                )
            }
            Spacer(modifier = Modifier.weight(1f)) // Espaçador flexível para empurrar o BottomNavigation para o final
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter) // Alinhamento no final da tela
        )
    }
}


@Composable
fun NotificacaoItem(
    message: String,
    onClose: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClose)
            .padding(bottom = 1.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Verde4) // Cor de fundo personalizada
            .padding(10.dp)
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.MailOutline,
            contentDescription = "Message",
            tint = Verde1, // Cor do ícone personalizada
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = message,
            color = Verde2, // Cor do texto preto
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            tint = Color.Black, // Cor do ícone preto
            modifier = Modifier.size(24.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotificacaoScreenPreview() {
    val messages = listOf(
        "Notificação 1",
        "Notificação 2 jsdfkglksdfjg sdfglkgklsdjfg dfglkjgdf fglkj sdfggsdfkljsdfg ",
        "Notificação 3",
        "Notificação 1",
        "Notificação 2 jsdfkglksdfjg sdfglkgklsdjfg dfglkjgdf fglkj sdfggsdfkljsdfg ",
        "Notificação 3",
        "Notificação 1",
        "Notificação 2 jsdfkglksdfjg sdfglkgklsdjfg dfglkjgdf fglkj sdfggsdfkljsdfg ",
        "Notificação 3"
    )

    NotificacaoScreen( onClose = {}, navController = rememberNavController())
}
