package tunisStore.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tunisStore.app.R
import tunisStore.app.ui.components.BottomNavigationBar
import tunisStore.app.ui.components.Header
import tunisStore.app.ui.data.AppData

@Composable
fun SearchResultCard(app: AppData) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = app.thumbnailRes),
                contentDescription = app.name,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(app.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(app.category, color = Color.Gray, fontSize = 13.sp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(14.dp))
                    Spacer(Modifier.width(4.dp))
                    Text(app.rating.toString(), fontSize = 13.sp)
                }
            }

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = app.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* TODO: Acheter ou Télécharger */ },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = if (app.price.contains("Gratuits", true) || app.price.contains("Achat")) "Télécharger" else "Acheter",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun RechercheScreen() {
    val searchQuery = remember { mutableStateOf("") }

    val searchResults = listOf(
        AppData("Photoshop", "Photo & Vidéo", 4.7, "250 Mo", "89,1 DN", R.drawable.ic_adobe_photoshop),
        AppData("Scanner", "Éducation", 5.0, "12 Mo", "Gratuits", R.drawable.ic_scanner),
        AppData("Excel", "Productivité", 4.9, "90 Mo", "9,1 DN", R.drawable.ic_microsoft_excel),
        AppData("Instagramm", "Réseaux-sociaux", 4.6, "120 Mo", "Achat Intégrée", R.drawable.ic_instagram),
        AppData("Anglais Vocab", "Éducation", 4.4, "60 Mo", "19,1 DN", R.drawable.ic_great_britain),
        AppData("Twitter", "Réseaux-sociaux", 4.8, "110 Mo", "Gratuits", R.drawable.ic_twitter)
    )

    Scaffold(
        topBar = { Header() },
        bottomBar = { BottomNavigationBar(selectedTab = "Recherche") },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 50.dp, vertical = 16.dp)
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(16.dp))

            Text(
                text = "Trouvez l'appli parfaite pour vous, en quelques secondes.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )

            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                placeholder = { Text("Rechercher une application") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Resultats",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )

            Spacer(Modifier.height(12.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(searchResults) { app ->
                    SearchResultCard(app = app)
                }
            }
        }


    }
}
