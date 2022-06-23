package academy.mukandrew.randm.rickandmortycatalog.ui.characters

import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun CharacterList(characterViewModel: CharacterViewModel = viewModel()) {
    when (val state = characterViewModel.listViewState.value) {
        BaseViewState.LoadingViewState -> CharacterLoadingState()
        is BaseViewState.SuccessViewState -> CharacterSuccessState(state.data)
        is BaseViewState.ErrorViewState -> CharacterErrorState()
    }
}

@Preview
@Composable
private fun CharacterLoadingState() {
    CircularProgressIndicator()
}

@Composable
private fun CharacterSuccessState(data: List<Character>) {
    Text(text = "Success State: $data")
}

@Composable
private fun CharacterErrorState() {
    Text(text = "Error State")
}
