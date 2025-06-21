package tunisStore.app.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tunisStore.app.CreationCompteActivity
import tunisStore.app.CompteBienCreeActivity
import tunisStore.app.R
import tunisStore.app.ui.theme.OrangePrimary
import tunisStore.app.ui.components.DropdownSelector

@Composable
fun CreationCompte2Screen() {
    val context = LocalContext.current

    var selectedStatut by remember { mutableStateOf("") }
    var selectedSexe by remember { mutableStateOf("") }

    val statutOptions = listOf("Étudiant", "Employé", "Indépendant", "Sans emploi")
    val sexeOptions = listOf("Homme", "Femme", "Autre")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
    ) {
        // HEADER ORANGE
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(OrangePrimary, RoundedCornerShape(bottomEnd = 32.dp, bottomStart = 32.dp))
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "< Retour",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable {
                            context.startActivity(Intent(context, CreationCompteActivity::class.java))
                        }
                    )
                    Text(
                        "Ignorer",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable {
                            context.startActivity(Intent(context, CompteBienCreeActivity::class.java))
                        }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Profil",
                    color = Color.White,
                    fontSize = 28.sp
                )
            }
        }

        // CONTENU PRINCIPAL
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 16.dp)
        ) {
            Text("Photo de profil", fontSize = 16.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color(0xFFE0E0E0), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_user),
                    contentDescription = "Placeholder photo",
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text("Votre statut", fontSize = 14.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            DropdownSelector(
                options = statutOptions,
                selectedOption = selectedStatut,
                onOptionSelected = { selectedStatut = it }
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text("Votre sexe", fontSize = 14.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            DropdownSelector(
                options = sexeOptions,
                selectedOption = selectedSexe,
                onOptionSelected = { selectedSexe = it }
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    context.startActivity(Intent(context, CompteBienCreeActivity::class.java))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(49.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = OrangePrimary)
            ) {
                Text("Continuer", color = Color.White)
            }
        }
    }
}
