package tunisStore.app.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tunisStore.app.Bienvenue
import tunisStore.app.CreationCompte2Activity
import tunisStore.app.R
import tunisStore.app.ui.theme.OrangePrimary

@Composable
fun CreationCompteScreen() {
    val context = LocalContext.current

    var nom by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tel by remember { mutableStateOf("") }
    var mdp by remember { mutableStateOf("") }
    var mdpVisible by remember { mutableStateOf(false) }
    var confirmMdp by remember { mutableStateOf("") }
    var confirmMdpVisible by remember { mutableStateOf(false) }
    var dateNaissance by remember { mutableStateOf("01 / 01 / 2000") }
    var accepterConditions by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        // Header orange incurvé
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(
                    color = OrangePrimary,
                    shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            context.startActivity(Intent(context, Bienvenue::class.java))
                        }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = "Retour",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Retour", color = Color.White, fontSize = 16.sp)
                }
                Spacer(Modifier.height(16.dp))
                Text(
                    "Créer\nun compte",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Carte blanche du formulaire
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 160.dp, start = 20.dp, end = 20.dp, bottom = 30.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    ChampTexte("Nom et Prénom", nom) { nom = it }
                    ChampTexte("Adresse e-mail", email) { email = it }
                    ChampTexte("Numéro de téléphone", tel) { tel = it }

                    ChampMotDePasse(
                        label = "Créer un mot de passe",
                        password = mdp,
                        visible = mdpVisible,
                        onPasswordChange = { mdp = it },
                        onVisibilityToggle = { mdpVisible = !mdpVisible }
                    )
                    Text(
                        "(8 caractères min , 1 chiffre)",
                        color = Color.Red,
                        fontSize = 12.sp
                    )

                    ChampMotDePasse(
                        label = "Confirmer le mot de passe",
                        password = confirmMdp,
                        visible = confirmMdpVisible,
                        onPasswordChange = { confirmMdp = it },
                        onVisibilityToggle = { confirmMdpVisible = !confirmMdpVisible }
                    )

                    ChampTexteAvecIcone(
                        label = "Date de naissance",
                        text = dateNaissance,
                        icon = R.drawable.ic_calendar,
                        onClick = { /* ouvrir DatePicker si besoin */ }
                    )

                    Spacer(Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = accepterConditions,
                            onCheckedChange = { accepterConditions = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = OrangePrimary
                            )
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "En créant un compte, vous acceptez nos ",
                            fontSize = 12.sp
                        )
                    }
                    Text(
                        text = "conditions d'utilisation et notre politique de confidentialité.",
                        fontSize = 12.sp,
                        color = OrangePrimary
                    )

                    Spacer(Modifier.height(20.dp))
                    Button(
                        onClick = {
                            context.startActivity(Intent(context, CreationCompte2Activity::class.java))
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = OrangePrimary
                        ),
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text("Créer mon compte", color = Color.White, fontSize = 16.sp)
                    }

                    Spacer(Modifier.height(16.dp))
                    Row {
                        Text("Vous avez déjà un compte Tounsi Store ? ", fontSize = 14.sp)
                        Text(
                            "connectez-vous",
                            fontSize = 14.sp,
                            color = OrangePrimary
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ChampTexte(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(label, fontSize = 14.sp, color = Color(0xFF696969))
        TextField(
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0xFF696969),
                focusedIndicatorColor = OrangePrimary
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ChampMotDePasse(
    label: String,
    password: String,
    visible: Boolean,
    onPasswordChange: (String) -> Unit,
    onVisibilityToggle: () -> Unit
) {
    Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(label, fontSize = 14.sp, color = Color(0xFF696969))
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = onVisibilityToggle) {
                    Icon(
                        painter = painterResource(
                            if (visible) R.drawable.ic_sleepy_eye else R.drawable.ic_eye_closed
                        ),
                        contentDescription = "Toggle Password Visibility",
                        tint = Color(0xFF696969)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0xFF696969),
                focusedIndicatorColor = OrangePrimary
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ChampTexteAvecIcone(
    label: String,
    text: String,
    icon: Int,
    onClick: () -> Unit
) {
    Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(label, fontSize = 14.sp, color = Color(0xFF696969))
        OutlinedTextField(
            value = text,
            onValueChange = {},
            trailingIcon = {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(onClick = onClick)
                        .size(24.dp),
                    tint = Color(0xFF696969)
                )
            },
            enabled = false,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                disabledIndicatorColor = Color(0xFF696969)
            )
        )
    }
}
