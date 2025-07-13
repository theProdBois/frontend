package tunisStore.app.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tunisStore.app.ui.components.BottomNavigationBar
import tunisStore.app.ui.components.Header
import tunisStore.app.ui.data.AppData
import kotlinx.serialization.json.Json
import tunisStore.app.AchatActivity
import tunisStore.app.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AchatScreen() {
    val context = LocalContext.current
    val intent = (context as? AchatActivity)?.intent
    val newAppJson = intent?.getStringExtra("APP_DATA")
    val newApp = newAppJson?.let { Json.decodeFromString<AppData>(it) }


    val achatList = remember { mutableStateListOf<AchatApp>().apply { addAll(fakeAchats) } }

    LaunchedEffect(newApp) {
        newApp?.let { app ->
            val currentDate = SimpleDateFormat("dd MMM yyyy à HH:mm", Locale.FRENCH).format(Date())
            val newAchat = AchatApp(
                name = app.name,
                category = app.category,
                date = currentDate,
                price = app.price,
                thumbnailRes = when {
                    app.name.contains("Adobe", ignoreCase = true) -> R.drawable.ic_adobe_photoshop
                    app.name.contains("Scanner", ignoreCase = true) -> R.drawable.ic_scanner
                    app.name.contains("Excel", ignoreCase = true) -> R.drawable.ic_microsoft_excel
                    app.name.contains("Twitter", ignoreCase = true) -> R.drawable.ic_twitter
                    app.name.contains("Minecraft", ignoreCase = true) -> R.drawable.ic_minecraft
                    else -> R.drawable.ic_apps
                },
                statusIcon = Icons.Default.PlayArrow,
                statusColor = Color.DarkGray,
                statusText = "Téléchargement en attente..."
            )
            achatList.add(newAchat)
            // Simulate download
            kotlinx.coroutines.delay(3000)
            achatList[achatList.indexOf(newAchat)] = newAchat.copy(
                statusIcon = Icons.Default.Download,
                statusColor = Color(0xFF008000),
                statusText = "Téléchargé"
            )
        }
    }

    Scaffold(
        topBar = { Header() },
        bottomBar = { BottomNavigationBar(selectedTab = "Achat") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Voici toutes les applications que vous avez achetées. Cliquez pour les télécharger à nouveau.",
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Liste des applications achetées",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(bottom = 72.dp)
            ) {
                items(achatList.size) { index ->
                    AchatCard(achatList[index])
                }
            }
        }
    }
}

@Composable
fun AchatCard(app: AchatApp) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = app.thumbnailRes),
                contentDescription = "Icône ${app.name}",
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(app.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(app.category, fontSize = 14.sp, color = Color(0xFF696969))
                Text("Date d'achat : ${app.date}", fontSize = 13.sp)
                Text("Prix payé : ${app.price}", fontSize = 13.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = app.statusIcon,
                        contentDescription = null,
                        tint = app.statusColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = app.statusText,
                        fontSize = 11.sp,
                        color = app.statusColor
                    )
                }
            }
        }
    }
}

data class AchatApp(
    val name: String,
    val category: String,
    val date: String,
    val price: String,
    val thumbnailRes: Int,
    val statusIcon: ImageVector,
    val statusColor: Color,
    val statusText: String
)

// Initial fake data
val fakeAchats = listOf(
    AchatApp(
        name = "Photoshop",
        category = "Photo & Vidéo",
        date = "29 Mai 2025 à 22:57",
        price = "89,57 DN",
        thumbnailRes = R.drawable.ic_adobe_photoshop,
        statusIcon = Icons.Default.Pause,
        statusColor = Color.DarkGray,
        statusText = "Téléchargement : 12 Mo / 150,5 Mo • 200 Ko/s • 6 minutes restantes"
    ),
    AchatApp(
        name = "Photoshop",
        category = "Photo & Vidéo",
        date = "29 Mai 2025 à 22:57",
        price = "89,57 DN",
        thumbnailRes = R.drawable.ic_microsoft_excel,
        statusIcon = Icons.Default.PlayArrow,
        statusColor = Color.DarkGray,
        statusText = "Téléchargement en attente..."
    ),
    AchatApp(
        name = "Trader",
        category = "Business",
        date = "27 Mai 2025 à 14:21",
        price = "56,10 DN",
        thumbnailRes = R.drawable.ic_education,
        statusIcon = Icons.Default.Download,
        statusColor = Color(0xFF008000),
        statusText = "Téléchargé"
    )
)

