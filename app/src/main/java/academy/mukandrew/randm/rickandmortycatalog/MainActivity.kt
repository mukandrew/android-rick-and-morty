package academy.mukandrew.randm.rickandmortycatalog

import academy.mukandrew.randm.rickandmortycatalog.compose.characters.CharacterScreen
import academy.mukandrew.randm.rickandmortycatalog.compose.theme.RickAndMortyCatalogTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyCatalogTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CharacterScreen()
                }
            }
        }
    }

    @Preview(
        showSystemUi = true,
        showBackground = true
    )
    @Composable
    fun DefaultPreview() {
        RickAndMortyCatalogTheme {
            CharacterScreen()
        }
    }
}
