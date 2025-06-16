package tunisStore.app.ui.data.remote

data class RemoteAppDataF(
    val packageName: String,
    val name: String,
    val shortDescription: String,
    val fullDescription: String,
    val developerId: String,
    val developerName: String,
    val categoryId: String,
    val tags: List<String>,
    val apkFilePath: String
)
