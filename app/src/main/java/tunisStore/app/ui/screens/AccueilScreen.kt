package tunisStore.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import tunisStore.app.ui.components.AppDetailsModal
import tunisStore.app.ui.components.BottomNavigationBar
import tunisStore.app.ui.components.Header
import tunisStore.app.ui.components.home.AppSection
import tunisStore.app.ui.components.home.WelcomeBanner
import tunisStore.app.ui.data.AppData
import tunisStore.app.ui.viewmodels.AccueilViewModel
import tunisStore.app.ui.viewmodels.UiState

@Composable
fun AccueilScreen(viewModel: AccueilViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedApp by remember { mutableStateOf<AppData?>(null) }

    Scaffold(
        topBar = { Header() },
        bottomBar = { BottomNavigationBar(selectedTab = "Accueil") }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .systemBarsPadding()
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 72.dp)
                    .fillMaxSize()
            ) {
                WelcomeBanner()

                when (uiState) {
                    is UiState.Loading -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is UiState.Success -> {
                        (uiState as UiState.Success).sections.forEach { section ->
                            AppSection(section, onAppClick = { selectedApp = it })
                        }
                    }

                    is UiState.Error -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = (uiState as UiState.Error).message,
                                color = Color.Red,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }

            // 🟧 Modal toujours au-dessus grâce à Box
            if (selectedApp != null) {
                AppDetailsModal(app = selectedApp!!, onClose = { selectedApp = null })
            }
        }
    }
}
