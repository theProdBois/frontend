package tunisStore.app.ui.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import tunisStore.app.AccueilActivity
import tunisStore.app.AchatActivity
import tunisStore.app.CategorieActivity
import tunisStore.app.RechercheActivity
import tunisStore.app.ui.theme.OrangePrimary

@Composable
fun BottomNavigationBar(selectedTab: String) {
    val context = LocalContext.current

    NavigationBar(containerColor = OrangePrimary) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Accueil",
                    tint = if (selectedTab == "Accueil") OrangePrimary else Color.Black
                )
            },
            label = { Text("Accueil", color = Color.Black) },
            selected = selectedTab == "Accueil",
            onClick = { startActivity(context, AccueilActivity()::class.java) },
            modifier = if (selectedTab == "Accueil") Modifier.background(OrangePrimary.copy(alpha = 0.2f)) else Modifier
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Category,
                    contentDescription = "Catégorie",
                    tint = if (selectedTab == "Catégorie") OrangePrimary else Color.Black
                )
            },
            label = { Text("Catégorie", color = Color.Black) },
            selected = selectedTab == "Catégorie",
            onClick = { startActivity(context, CategorieActivity::class.java) },
            modifier = if (selectedTab == "Catégorie") Modifier.background(OrangePrimary.copy(alpha = 0.2f)) else Modifier
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Achat",
                    tint = if (selectedTab == "Achat") OrangePrimary else Color.Black
                )
            },
            label = { Text("Achat", color = Color.Black) },
            selected = selectedTab == "Achat",
            onClick = { startActivity(context, AchatActivity::class.java) },
            modifier = if (selectedTab == "Achat") Modifier.background(OrangePrimary.copy(alpha = 0.2f)) else Modifier
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Recherche",
                    tint = if (selectedTab == "Recherche") OrangePrimary else Color.Black
                )
            },
            label = { Text("Recherche", color = Color.Black) },
            selected = selectedTab == "Recherche",
            onClick = { startActivity(context, RechercheActivity::class.java) },
            modifier = if (selectedTab == "Recherche") Modifier.background(OrangePrimary.copy(alpha = 0.2f)) else Modifier
        )
    }
}

// Fonction utilitaire pour lancer une activité
private fun startActivity(context: Context, activityClass: Class<*>) {
    val intent = Intent(context, activityClass)
    context.startActivity(intent)
}
