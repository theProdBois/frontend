package tunisStore.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tunisStore.app.ui.theme.OrangePrimary
import tunisStore.app.ui.theme.RedColor

class SeConnecter : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeConnecterScreen()
        }
    }
}

@Composable
fun SeConnecterScreen() {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp)
    ) {
        // En-tête orange
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(OrangePrimary)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "< Retour",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .clickable {
                        context.startActivity(Intent(context, Bienvenue::class.java))
                    }
            )
            Spacer(modifier = Modifier.width(70.dp))
            Text(
                text = "Se connecter",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 10.dp)
            )
        }

        // Corps du formulaire
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text("Adresse e-mail ou numéro de téléphone", fontSize = 14.sp)
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                placeholder = { Text("adresse@gmail.com") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true
            )

            Text("Mot de passe", fontSize = 14.sp)
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                placeholder = { Text("Mot de passe") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Afficher le mot de passe"
                        )
                    }
                }
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it }
                )
                Text("Se souvenir de moi")
            }

            Button(
                onClick = {
                    context.startActivity(Intent(context, AccueilActivity::class.java))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = OrangePrimary)
            ) {
                Text("Se connecter", color = Color.White)
            }

            OutlinedButton(
                onClick = {
                    // TODO: Connexion Google
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Se connecter avec Google")
            }

            Text(
                "Vous n'avez pas de compte Tunis Store ?",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp
            )

            Text(
                text = "Inscrivez-vous",
                color = RedColor,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // TODO: Rediriger vers Inscription
                    },
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Text(
                text = "Mot de passe oublié ?",
                color = RedColor,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clickable {
                        // TODO: Rediriger vers Mot de passe oublié
                    },
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}
