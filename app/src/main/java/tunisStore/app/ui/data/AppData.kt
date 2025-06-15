package tunisStore.app.ui.data

import tunisStore.app.R

data class AppData(
    val name: String,
    val category: String,
    val rating: Double,
    val size: String,
    val thumbnailRes: Int
)

data class AppSectionData(
    val title: String,
    val apps: List<AppData>
)

val fakeAppSections = listOf(
    AppSectionData(
        "Recommandé pour vous",
        listOf(
            AppData("Dream", "Réseaux sociaux", 4.8, "111,5 Mo", R.drawable.ic_dream),
            AppData("Rally 214", "Jeux", 4.2, "500 Mo", R.drawable.ic_rally),
            AppData("Read-Book", "Éducation", 4.9, "21,2 Mo", R.drawable.ic_book)
        )
    ),
    AppSectionData(
        "Populaire",
        listOf(
            AppData("Instagram", "Réseaux sociaux", 4.6, "120 Mo", R.drawable.ic_instagram),
            AppData("WhatsApp", "Réseaux sociaux", 4.7, "100 Mo", R.drawable.ic_whatsapp),
            AppData("Photoshop", "Photo & Vidéo", 4.5, "1,5 Go", R.drawable.ic_adobe_photoshop)
        )
    ),
    AppSectionData(
        "Nouveautés",
        listOf(
            AppData("Call OF D", "Jeux", 4.0, "1,2 Go", R.drawable.ic_call_of_duty),
            AppData("DES", "Jeux", 3.9, "500 Mo", R.drawable.ic_des)
        )
    ),
    AppSectionData(
        "Promotions",
        listOf(
            AppData("Dream", "Réseaux sociaux", 4.8, "111,5 Mo", R.drawable.ic_dream),
            AppData("Rally 214", "Jeux", 4.2, "500 Mo", R.drawable.ic_rally)
        )
    )
)
