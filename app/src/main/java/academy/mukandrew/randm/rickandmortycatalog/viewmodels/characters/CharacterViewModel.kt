package academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters

import academy.mukandrew.randm.rickandmortycatalog.viewmodels.BaseViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterSuccessStateUIModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState
import androidx.compose.runtime.State

abstract class CharacterViewModel : BaseViewModel() {
    abstract val listViewState: State<BaseViewState<CharacterSuccessStateUIModel>>

    abstract fun loadNextPage(lastIndexVisible: Int, listLastIndex: Int): Boolean
}
