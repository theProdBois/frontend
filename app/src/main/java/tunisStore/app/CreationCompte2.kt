package tunisStore.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreationCompte2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creation_compte2)

        val btnContinuer = findViewById<Button>(R.id.btnContinuer)
        val btnretour = findViewById<TextView>(R.id.btnRetour)

        btnContinuer.setOnClickListener {
            val intent = Intent(this, CompteBienCree::class.java)
            startActivity(intent)
        }

        btnretour.setOnClickListener {
            val intent = Intent(this, CreationCompte::class.java)
            startActivity(intent)
        }
    }
}