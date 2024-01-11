package academy.mukandrew.randm.rickandmortycatalog.compose.characters

import academy.mukandrew.randm.rickandmortycatalog.R
import academy.mukandrew.randm.rickandmortycatalog.compose.characters.models.CharacterScreenPreviewParamProvider
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterUIModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CharacterItemView(character: CharacterUIModel) {
    ConstraintLayout {
        val (cardRef, textRef) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .constrainAs(cardRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = character.imageUrl,
                    contentDescription = character.name,
                    placeholder = painterResource(id = R.drawable.no_picture),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .height(72.dp)
                        .width(72.dp)
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = character.getTitle(),
                        fontSize = 16.sp
                    )
                    Text(
                        text = character.getSubtitle(),
                        fontSize = 12.sp
                    )
                    Text(
                        text = character.getNamedGender(),
                        fontSize = 12.sp
                    )
                }
            }
        }
        Text(
            text = character.getNamedStatus(),
            fontSize = 14.sp,
            modifier = Modifier
                .constrainAs(textRef) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
        )
    }
}

@Preview
@Composable
private fun CharacterItemViewPreview() {
    CharacterItemView(character = CharacterScreenPreviewParamProvider.characterList.random())
}
