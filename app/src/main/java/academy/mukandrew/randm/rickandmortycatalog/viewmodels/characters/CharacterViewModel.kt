package academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters

import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterListUseCase
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.BaseViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : BaseViewModel() {
    private val _listViewState = mutableStateOf<BaseViewState<List<Character>>>(
        BaseViewState.LoadingViewState
    )
    val listViewState: State<BaseViewState<List<Character>>>
        get() = _listViewState

    fun requestCharacterList() {
        launcherIO {
            _listViewState.value = BaseViewState.LoadingViewState

            getCharacterListUseCase(pageNumber = 1)
                .onSuccess {
                    _listViewState.value = BaseViewState.SuccessViewState(it.results)
                }
                .onFailure {
                    _listViewState.value = BaseViewState.ErrorViewState(it)
                }
        }
    }
}
