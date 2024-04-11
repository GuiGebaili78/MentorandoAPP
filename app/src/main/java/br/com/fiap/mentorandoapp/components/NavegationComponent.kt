import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mentorandoapp.R
import br.com.fiap.mentorandoapp.ui.theme.Verde2
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import br.com.fiap.mentorandoapp.ui.theme.Verde3


@Composable
fun BottomNavigation(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Verde3) // Adiciona o background que ocupa todo o espaço horizontal
            .padding(2.dp),

        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItem(
            icon = R.drawable.back_24,
            contentDescription = "Notificação",
            route = "LoginScreen",
            navController = navController
        )
        NavItem(
            icon = R.drawable.baseline_person_pin_24,
            contentDescription = "Perfil",
            route = "perfil",
            navController = navController
        )
        NavItem(
            icon = R.drawable.person_search_24,
            contentDescription = "Carrossel",
            route = "ConexaoCardScreen",
            navController = navController
        )

        NavItem(
            icon = R.drawable.baseline_notifications_24,
            contentDescription = "Notificação",
            route = "NotificacaoScreen",
            navController = navController
        )
    }
}


@Composable
private fun NavItem(
    icon: Int,
    contentDescription: String,
    route: String,
    navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = icon)),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.navigate(route)
                }
        )
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun BottomNavigationPreview() {
    val navController = rememberNavController()
    BottomNavigation(navController = navController)
}
