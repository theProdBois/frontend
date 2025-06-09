package tunisStore.app

interface ApiService {
    //@GET("catalogue")
    suspend fun getCatalogue(): Map<String, List<AppModel>>
}
