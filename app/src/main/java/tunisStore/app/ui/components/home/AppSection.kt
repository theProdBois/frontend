package tunisStore.app.ui.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tunisStore.app.ui.data.AppData
import tunisStore.app.ui.data.AppSectionData

@Composable
fun AppSection(section: AppSectionData, onAppClick: (AppData) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = section.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "Voir plus",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.clickable { /* Action voir plus */ }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(contentPadding = PaddingValues(end = 16.dp)) {
            items(section.apps) { app ->
                AppCard(app = app, onClick = { onAppClick(app) })
            }
        }
    }
}
