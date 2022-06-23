package academy.mukandrew.randm.rickandmortycatalog

import academy.mukandrew.randm.rickandmortycatalog.ui.characters.CharacterList
import academy.mukandrew.randm.rickandmortycatalog.ui.theme.RickAndMortyCatalogTheme
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModel
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyCatalogTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CharacterList(characterViewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        characterViewModel.requestCharacterList()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickAndMortyCatalogTheme {
        CharacterList()
    }
}
