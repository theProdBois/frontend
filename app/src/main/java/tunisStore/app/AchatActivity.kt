package tunisStore.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tunisStore.app.ui.data.AppData
import tunisStore.app.ui.screens.AchatScreen
import tunisStore.app.ui.theme.TunisStoreTheme
import kotlinx.serialization.json.Json

class AchatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TunisStoreTheme {
                val appJson = intent.getStringExtra("APP_DATA")
                val app = appJson?.let { Json.decodeFromString<AppData>(it) }
                when {
                    app == null -> {
                        AchatScreen()
                    }
                    app.price != "Gratuits" -> {
                        PaymentScreen(app)
                    }
                    else -> {
                        AchatScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun PaymentScreen(app: AppData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Paiement pour ${app.name} - ${app.price}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Implement payment logic */ }) {
            Text("Confirmer l'achat")
        }
    }
}