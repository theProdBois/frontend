package tunisStore.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import tunisStore.app.ui.data.AppSectionData
import tunisStore.app.ui.theme.OrangePrimary

@Composable
fun CategoriesScreen() {
    Scaffold(
        topBar = { Header() },
        bottomBar = { BottomNavigationBar(selectedTab = "Catégorie") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 50.dp, vertical = 16.dp)
                .fillMaxSize()
        ) {
            CategoriesTitle()
            CategoriesIntroText()
            CategoriesFilterBar()
            // Sections d'applications
            AppSection(
                AppSectionData(
                    title = "Pagarits",
                    apps = fakePaidApps
                ),
                showSeeMore = false
            )
            AppSection(
                AppSectionData(
                    title = "Premium",
                    apps = fakePremiumApps
                ),
                showSeeMore = true
            )
            AppSection(
                AppSectionData(
                    title = "Gratuits",
                    apps = fakeFreeApps
                ),
                showSeeMore = true
            )
        }
    }
}

@Composable
fun CategoriesTitle() {
    Text(
        text = "Catégorie",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun CategoriesIntroText() {
    Text(
        text = "Explorez nos applications par thème. Trouvez ce qu'il vous faut en un clic !",
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
    )
}

@Composable
fun CategoriesFilterBar() {
    var selectedCategory by remember { mutableStateOf("Pour vous") }
    val categories = listOf("Pour vous", "Jeux", "Education", "Musique", "Photo&Vidéo")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            categories.forEach { category ->
                Column(
                    modifier = Modifier.clickable { selectedCategory = category }
                ) {
                    Text(
                        text = category,
                        fontWeight = if (category == selectedCategory) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 14.sp,
                        color = if (category == selectedCategory) Color.Black else Color(0xFF696969)
                    )
                    if (category == selectedCategory) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Box(
                            modifier = Modifier
                                .height(2.dp)
                                .width(40.dp)
                                .background(OrangePrimary)
                        )
                    }
                }
            }
        }

    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { /* TO DO */ },
        horizontalArrangement = Arrangement.End,

    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "Filter",
            tint = Color(0xFF696969),
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Toutes les tarifications",
            fontSize = 14.sp,
            color = Color(0xFF696969)
        )
    }
}

@Composable
fun AppSection(section: AppSectionData, showSeeMore: Boolean) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = section.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            if (showSeeMore) {
                Text(
                    text = "voir plus",
                    fontSize = 14.sp,
                    color = Color(0xFF696969),
                    modifier = Modifier.clickable { /* TO DO */ }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(contentPadding = PaddingValues(end = 16.dp)) {
            items(section.apps) { app ->
                CategoryAppCard(app)
            }
        }
    }
}

@Composable
fun CategoryAppCard(app: AppData) {
    Card(
        modifier = Modifier
            .width(190.dp)
            .padding(end = 8.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.Gray
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, Color(0xFFFF4216))
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = app.thumbnailRes),
                contentDescription = "Icône de l'application ${app.name}",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = app.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = app.category,
                fontSize = 12.sp,
                color = Color(0xFF696969),
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFF696969),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = app.rating.toString(),
                    fontSize = 12.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = app.price,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = if (app.price == "Gratuits" || app.price == "Achat Intégrée") Color(0xFF696969) else Color.Black
                    )
                    Button(
                        onClick = { /* TO DO */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = OrangePrimary,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .height(30.dp)
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = if (app.price.contains("Gratuits", true) || app.price.contains("Achat")) "Télécharger" else "Acheter",
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }
    }
}

// Données fictives pour les sections
val fakePaidApps = listOf(
    AppData("Photoshop", "Photo&Vidéo", 4.7, "1,5 Go", "89,1 DN", R.drawable.ic_adobe_photoshop),
    AppData("Scanner", "Business", 5.7, "100 Mo", "9,1 DN", R.drawable.ic_scanner)
)

val fakePremiumApps = listOf(
    AppData("Trader", "Business", 4.5, "200 Mo", "8,1 DN/M", R.drawable.ic_training),
    AppData("Excel", "Business", 4.8, "300 Mo", "19,1 DN/M", R.drawable.ic_microsoft_excel)
)

val fakeFreeApps = listOf(
    AppData("Anglais Vocab", "Education", 4.6, "50 Mo", "Achat Intégrée", R.drawable.ic_great_britain),
    AppData("Twitter", "Reseau-sociaux", 4.3, "120 Mo", "Gratuits", R.drawable.ic_twitter),
    AppData("FaceBook", "Reseau-sociaux", 4.2, "150 Mo", "Gratuits", R.drawable.ic_facebook)
)
