package tunisStore.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Bienvenue : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenue)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)

        btnLogin.setOnClickListener {
            val intent = Intent(this, SeConnecter::class.java)
            startActivity(intent)
        }

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, CreationCompte::class.java)
            startActivity(intent)
        }
    }
}
