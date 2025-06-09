package tunisStore.app

data class AppModel(
    val id: Int,
    val name: String,
    val category: String,
    val rating: Double,
    val size: String,
    val imageUrl: String
)
