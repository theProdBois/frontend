package tunisStore.app.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import tunisStore.app.AccueilActivity
import tunisStore.app.R
import tunisStore.app.ui.model.Categorie
import tunisStore.app.ui.theme.OrangePrimary

@Composable
fun ValidationChoixPreferenceScreen() {
    val context = LocalContext.current

    val categories = listOf(
        Categorie("Jeux", R.drawable.ic_jeux),
        Categorie("Éducation", R.drawable.ic_education),
        Categorie("Santé", R.drawable.ic_sante),
        Categorie("Photo & Vidéo", R.drawable.ic_photo),
        Categorie("Musique", R.drawable.ic_music),
        Categorie("Finance", R.drawable.ic_finance)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2))
    ) {
        // Header orange incurvé
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    painterResource(R.drawable.header_background)
                        .let { painter ->
                            Brush.verticalGradient(listOf(OrangePrimary, OrangePrimary))
                        }
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Ignorer",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            context.startActivity(Intent(context, AccueilActivity::class.java))
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Que souhaitez-vous découvrir\nsur Tounsi Store",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texte d'instruction
        Text(
            text = "Choisissez les catégories qui vous intéressent le plus pour recevoir des recommandations personnalisées.",
            color = Color(0xFF333333),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Catégories :",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
            modifier = Modifier.padding(start = 24.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(categories) { category ->
                CategoryItem(category)
            }
        }

        Button(
            onClick = {
                context.startActivity(Intent(context, tunisStore.app.AccueilActivity::class.java))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = OrangePrimary),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text(
                text = "Valider mes choix",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun CategoryItem(categorie: Categorie) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .aspectRatio(1f)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = categorie.iconRes),
            contentDescription = categorie.nom,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = categorie.nom,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}
