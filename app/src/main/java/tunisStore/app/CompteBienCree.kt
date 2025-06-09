package tunisStore.app

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import android.animation.Animator

class CompteBienCree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compte_bien_cree)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        // Animation de la barre de progression
        val animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100).apply {
            duration = 5000 // 5 secondes
        }

        // Écouteur pour déclencher l’action après l’animation
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator) {
                val intent = Intent(this@CompteBienCree, ValidationChoixPreference::class.java)
                startActivity(intent)
                finish() // Optionnel : fermer cette activité
            }

            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })

        animator.start()
    }
}
