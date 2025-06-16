package tunisStore.app.ui.data.remote

import retrofit2.http.GET

interface AppApiService {
    @GET("/api/apks")
    suspend fun getApps(): List<ApkData>
}