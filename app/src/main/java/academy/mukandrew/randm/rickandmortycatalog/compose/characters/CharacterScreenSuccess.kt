package academy.mukandrew.randm.rickandmortycatalog.compose.characters

import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterSuccessStateUIModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun CharacterSuccessState(
    data: CharacterSuccessStateUIModel,
    characterViewModel: CharacterViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CharacterScreenList(data = data, viewModel = characterViewModel)
    }
}
