package academy.mukandrew.randm.rickandmortycatalog.compose.characters

import academy.mukandrew.randm.common.exceptions.NoContentException
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun CharacterErrorState(throwable: Throwable) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = throwable.message.orEmpty())
    }
}

@Preview
@Composable
private fun CharacterErrorStatePreview() {
    CharacterErrorState(throwable = NoContentException())
}
