package tunisStore.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreationCompte : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creation_compte)

        val creerMonCompte = findViewById<Button>(R.id.creerMonCompte)
        val btnretour = findViewById<TextView>(R.id.btnRetour)

        creerMonCompte.setOnClickListener {
            val intent = Intent(this, CreationCompte2::class.java)
            startActivity(intent)
        }

        btnretour.setOnClickListener {
            val intent = Intent(this, Bienvenue::class.java)
            startActivity(intent)
        }
    }
}
