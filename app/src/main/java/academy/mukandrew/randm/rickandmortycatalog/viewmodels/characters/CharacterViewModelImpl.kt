package academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters

import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterListUseCase
import academy.mukandrew.randm.domain.pagination.models.PageResult
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.mappers.toListUIModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterSuccessStateUIModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterUIModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.ErrorViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.LoadingViewState
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.models.BaseViewState.SuccessViewState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class CharacterViewModelImpl @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : CharacterViewModel() {
    private val _listViewState =
        mutableStateOf<BaseViewState<CharacterSuccessStateUIModel>>(LoadingViewState)
    override val listViewState: State<BaseViewState<CharacterSuccessStateUIModel>>
        get() = _listViewState

    private val successStateBuilder = CharacterSuccessStateUIModel()
    private var pageResults: MutableList<PageResult<Character>> = mutableListOf()
    private var requestJob: Job? = null

    init {
        requestCharacterList(pageNumber = FIRST_PAGE_NUMBER)
    }

    private fun requestCharacterList(pageNumber: Int) {
        if (requestJob?.isActive == true) return
        requestJob = launcherIO {
            getCharacterListUseCase(pageNumber = pageNumber)
                .onSuccess {
                    _listViewState.value =
                        SuccessViewState(successStateBuilder.copy(characters = getList(it)))
                }
                .onFailure { _listViewState.value = ErrorViewState(it) }
        }
    }

    private fun getList(result: PageResult<Character>): List<CharacterUIModel> {
        pageResults.add(result)
        return pageResults.flatMap { it.results }.toListUIModel()
    }

    override fun loadNextPage(lastIndexVisible: Int, listLastIndex: Int): Boolean {
        return (lastIndexVisible >= (listLastIndex - INDEX_TO_LOAD_NEXT_PAGE)).also {
            if (!it) return@also

            val pageNumber = pageResults.lastOrNull()?.info?.next ?: FIRST_PAGE_NUMBER
            if (pageResults.none { page -> page.info.currentPage == pageNumber }) {
                requestCharacterList(pageNumber = pageNumber)
            }
        }
    }

    private companion object {
        private const val FIRST_PAGE_NUMBER = 1
        private const val INDEX_TO_LOAD_NEXT_PAGE = 3
    }
}
