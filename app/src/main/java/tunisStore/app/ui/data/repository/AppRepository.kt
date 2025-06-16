package tunisStore.app.ui.data.repository

import tunisStore.app.ui.data.remote.ApkData
import tunisStore.app.ui.data.remote.RetrofitInstance

class AppRepository {
    suspend fun getApps(): List<ApkData> {
        return RetrofitInstance.api.getApps()
    }
}