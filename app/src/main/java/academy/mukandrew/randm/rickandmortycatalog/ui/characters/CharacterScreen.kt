package academy.mukandrew.randm.rickandmortycatalog.ui.characters

import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun CharacterList(characterViewModel: CharacterViewModel = viewModel()) {
    when (characterViewModel.listViewState.value) {
        BaseViewState.LoadingViewState -> CharacterLoadingState()
        is BaseViewState.SuccessViewState -> CharacterSuccessState()
        is BaseViewState.ErrorViewState -> CharacterErrorState()
    }
}

@Preview
@Composable
private fun CharacterLoadingState() {
    CircularProgressIndicator()
}

@Composable
private fun CharacterSuccessState() {
}

@Composable
private fun CharacterErrorState() {
}
