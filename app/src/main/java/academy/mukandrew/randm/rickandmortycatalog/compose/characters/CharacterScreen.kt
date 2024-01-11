package academy.mukandrew.randm.rickandmortycatalog.compose.characters

import academy.mukandrew.randm.rickandmortycatalog.compose.characters.models.CharacterScreenPreviewParamProvider
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModelImpl
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterSuccessStateUIModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.ErrorViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.LoadingViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.SuccessViewState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun CharacterScreen(
    characterViewModel: CharacterViewModel = viewModel<CharacterViewModelImpl>(),
    state: BaseViewState<CharacterSuccessStateUIModel> = characterViewModel.listViewState.value
) {
    when (state) {
        LoadingViewState -> CharacterLoadingState()
        is SuccessViewState -> CharacterSuccessState(state.data, characterViewModel)
        is ErrorViewState -> CharacterErrorState(state.throwable)
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun CharacterScreenPreview(
    @PreviewParameter(CharacterScreenPreviewParamProvider::class)
    state: BaseViewState<CharacterSuccessStateUIModel>
) {
    CharacterScreen(characterViewModel = CharacterScreenPreviewParamProvider.viewModel(state))
}
