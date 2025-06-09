package tunisStore.app

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dots: List<View>
    private val delay = 1000L // 1 seconde entre chaque

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupérer les vues des points
        dots = listOf(
            findViewById(R.id.dot1),
            findViewById(R.id.dot2),
            findViewById(R.id.dot3),
            findViewById(R.id.dot4),
            findViewById(R.id.dot5),
            findViewById(R.id.dot6)
        )

        // Démarrer l'animation
        startDotAnimation(0)
    }

    private fun startDotAnimation(index: Int) {
        if (index >= dots.size) {
            // Animation terminée : passer à l'écran suivant
            val intent = Intent(this, Bienvenue::class.java)
            startActivity(intent)
            finish()
            return
        }

        // Changer la couleur du point courant en rouge
        val dot = dots[index]
        (dot.background as GradientDrawable).setColor(0xFFE60026.toInt()) // Rouge

        // Appeler la suite après 1 seconde
        Handler(Looper.getMainLooper()).postDelayed({
            startDotAnimation(index + 1)
        }, delay)
    }
}
