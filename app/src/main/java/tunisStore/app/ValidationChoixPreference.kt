package tunisStore.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import tunisStore.app.databinding.ValidationChoixPreferenceBinding

class ValidationChoixPreference : AppCompatActivity() {
    private lateinit var binding: ValidationChoixPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ValidationChoixPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categories = listOf(
            Categorie("Jeux", R.drawable.ic_jeux),
            Categorie("Éducation", R.drawable.ic_education),
            Categorie("Santé", R.drawable.ic_sante),
            Categorie("Photo & Vidéo", R.drawable.ic_photo),
            Categorie("Musique", R.drawable.ic_music),
            Categorie("Finance", R.drawable.ic_finance)
        )

        binding.gridCategories.layoutManager = GridLayoutManager(this, 2)
        binding.gridCategories.adapter = CategorieAdapter(categories)
    }
}
