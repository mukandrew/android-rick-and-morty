package academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models

data class CharacterSuccessStateUIModel(
    var characters: List<CharacterUIModel> = emptyList(),
    var filters: String = String()
)
