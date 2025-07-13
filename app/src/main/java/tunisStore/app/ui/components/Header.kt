package tunisStore.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tunisStore.app.R
import tunisStore.app.ui.theme.OrangePrimary


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notifications",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { /* TO DO */ }
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "Profile",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { /* TO DO */ }
            )
        }
    }
}


