package academy.mukandrew.randm.rickandmortycatalog.compose.characters.models

import academy.mukandrew.randm.common.exceptions.NoContentException
import academy.mukandrew.randm.domain.characters.models.CharacterGender
import academy.mukandrew.randm.domain.characters.models.CharacterStatus
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterSuccessStateUIModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterUIModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.ErrorViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.LoadingViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.SuccessViewState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CharacterScreenPreviewParamProvider :
    PreviewParameterProvider<BaseViewState<CharacterSuccessStateUIModel>> {

    override val values: Sequence<BaseViewState<CharacterSuccessStateUIModel>>
        get() = sequenceOf(loadingState, successState, errorState)

    private class CharacterViewModelPreviewProvider(
        private val state: BaseViewState<CharacterSuccessStateUIModel>
    ) : CharacterViewModel() {
        override val listViewState: State<BaseViewState<CharacterSuccessStateUIModel>>
            get() = mutableStateOf(state)

        override fun loadNextPage(lastIndexVisible: Int, listLastIndex: Int): Boolean {
            return true
        }
    }

    internal companion object DefaultData {
        fun viewModel(state: BaseViewState<CharacterSuccessStateUIModel>): CharacterViewModel {
            return CharacterViewModelPreviewProvider(state)
        }

        val characterList = listOf(
            CharacterUIModel(
                id = 1,
                name = "First Name",
                status = CharacterStatus.DEAD,
                gender = CharacterGender.GENDERLESS,
                species = "First Specie",
                type = "First Type",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            ),
            CharacterUIModel(
                id = 2,
                name = "Second Name",
                status = CharacterStatus.ALIVE,
                gender = CharacterGender.MALE,
                species = "Second Specie",
                type = "Second Type",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            ),
            CharacterUIModel(
                id = 3,
                name = "Third Name",
                status = CharacterStatus.UNKNOWN,
                gender = CharacterGender.FEMALE,
                species = "Third Specie",
                type = "Third Type",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/3.jpeg"
            )
        )

        val loadingState = LoadingViewState
        val successState =
            SuccessViewState(CharacterSuccessStateUIModel(characters = characterList))
        val errorState = ErrorViewState(NoContentException())
    }
}
