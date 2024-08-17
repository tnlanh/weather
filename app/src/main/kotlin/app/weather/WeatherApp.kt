package app.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import app.weather.ui.theme.AppTheme

@Composable
fun WeatherApp() {
  AppTheme {
    Scaffold { paddingValues ->
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(paddingValues),
      ) {
        Text(
          text = stringResource(R.string.app_name),
          modifier = Modifier.align(Alignment.Center),
        )
      }
    }
  }
}
