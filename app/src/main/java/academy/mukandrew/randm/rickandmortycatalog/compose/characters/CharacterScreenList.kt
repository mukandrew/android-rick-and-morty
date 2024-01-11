package academy.mukandrew.randm.rickandmortycatalog.compose.characters

import academy.mukandrew.randm.rickandmortycatalog.R
import academy.mukandrew.randm.rickandmortycatalog.compose.characters.models.CharacterScreenPreviewParamProvider
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.CharacterViewModel
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterSuccessStateUIModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun CharacterScreenList(
    data: CharacterSuccessStateUIModel,
    viewModel: CharacterViewModel
) {
    val listState = rememberLazyListState()
    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.content_padding_horizontal),
            vertical = dimensionResource(id = R.dimen.content_padding_vertical)
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.content_padding_between)
        ),
        state = listState
    ) {
        item {
            CharacterScreenFilter()
        }

        items(
            items = data.characters,
            key = { it.id }
        ) {
            CharacterItemView(it)
        }

        item {
            val index =
                listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: Int.MIN_VALUE

            if (viewModel.loadNextPage(index, data.characters.lastIndex)) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Preview
@Composable
private fun CharacterScreenListPreview() {
    val state = CharacterScreenPreviewParamProvider.successState
    CharacterScreenList(
        data = state.data,
        viewModel = CharacterScreenPreviewParamProvider.viewModel(state)
    )
}
