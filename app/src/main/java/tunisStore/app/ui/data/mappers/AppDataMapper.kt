package tunisStore.app.ui.data.mappers

import tunisStore.app.R
import tunisStore.app.ui.data.AppData
import tunisStore.app.ui.data.remote.RemoteAppData

fun RemoteAppData.toAppData(): AppData {
    val name = this.name
    val category = when {
        tags.contains("productivity") -> "Productivité"
        tags.contains("game") -> "Jeux"
        tags.contains("business") -> "Business"
        categoryId == "a559a70c-f8cb-444c-9c5a-22a0d869a69c" -> "Productivité"
        else -> "Inconnu"
    }
    val thumbnailRes = when {
        name.contains("Adobe", ignoreCase = true) -> R.drawable.ic_adobe_photoshop
        name.contains("Scanner", ignoreCase = true) -> R.drawable.ic_scanner
        name.contains("Excel", ignoreCase = true) -> R.drawable.ic_microsoft_excel
        name.contains("Twitter", ignoreCase = true) -> R.drawable.ic_twitter
        name.contains("Minecraft", ignoreCase = true) -> R.drawable.ic_minecraft
        else -> R.drawable.ic_apps
    }
    val rating = this.rating.toDoubleOrNull() ?: 4.5
    val size = versions.firstOrNull()?.let { version ->
        if (version.fileSize > 0) "${version.fileSize / 1024 / 1024} Mo" else "100 Mo"
    } ?: "100 Mo"
    val price = when {
        tags.contains("productivity") -> "19,9 DN"
        name.contains("Minecraft", ignoreCase = true) -> "29,9 DN"
        else -> "Gratuits"
    }
    val developer = developerName
    val description = fullDescription
    val screenshots = iconUrl?.let { listOf(thumbnailRes) } ?: emptyList()

    return AppData(
        name = name,
        category = category,
        rating = rating,
        size = size,
        price = price,
        thumbnailRes = thumbnailRes,
        developer = developer,
        description = description,
        screenshots = screenshots
    )
}