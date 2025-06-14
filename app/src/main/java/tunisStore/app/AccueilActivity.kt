package tunisStore.app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AccueilActivity : AppCompatActivity() {

    private lateinit var notificationIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var logo: ImageView
    private lateinit var containerSections: LinearLayout
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil)

        // Références aux vues
        notificationIcon = findViewById(R.id.notification_icon)
        profileIcon = findViewById(R.id.profile_icon)
        logo = findViewById(R.id.logo)
        containerSections = findViewById(R.id.container_sections)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        setupListeners()
        loadFakeSections()
    }

    private fun setupListeners() {
        notificationIcon.setOnClickListener {
            Toast.makeText(this, "Notifications à venir", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, NotificationsActivity::class.java))
        }

        profileIcon.setOnClickListener {
            startActivity(Intent(this, SeConnecter::class.java))
        }

        logo.setOnClickListener {
            Toast.makeText(this, "Logo cliqué", Toast.LENGTH_SHORT).show()
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_accueil -> {
                    Toast.makeText(this, "Déjà sur l'accueil", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_recherche -> {
                    startActivity(Intent(this, RechercheActivity::class.java))
                    true
                }
                R.id.nav_categories -> {
                    startActivity(Intent(this, CategoriesActivity::class.java))
                    true
                }
                R.id.nav_achat -> {
                    startActivity(Intent(this, AchatActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFakeSections() {
        // Exemple de remplissage fictif
        val sections = listOf("Recommandé", "Populaire", "Nouveautés")

        for (section in sections) {
            val sectionView = layoutInflater.inflate(R.layout.section_app_horizontal, containerSections, false)
            // Tu peux passer le titre à la vue si besoin ici
            containerSections.addView(sectionView)
        }
    }
}
