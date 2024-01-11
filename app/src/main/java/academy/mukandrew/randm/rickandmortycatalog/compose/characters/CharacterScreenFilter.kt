package academy.mukandrew.randm.rickandmortycatalog.compose.characters

import academy.mukandrew.randm.domain.characters.models.CharacterGender
import academy.mukandrew.randm.domain.characters.models.CharacterStatus
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CharacterScreenFilter() {
    var isFilterExpanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isFilterExpanded = !isFilterExpanded }
            ) {
                Text(
                    text = "Filters",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                val rotateAngleAnim by animateFloatAsState(
                    targetValue = if (isFilterExpanded) 180f else 0f
                )
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .align(Alignment.CenterEnd)
                        .rotate(rotateAngleAnim)
                )
            }
            AnimatedVisibility(
                visible = isFilterExpanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    var filterName by remember { mutableStateOf(String()) }
                    var filterSpecie by remember { mutableStateOf(String()) }
                    var filterType by remember { mutableStateOf(String()) }
                    var selectedStatusIndex by remember { mutableStateOf(0) }
                    var selectedGenderIndex by remember { mutableStateOf(0) }
                    OutlinedTextField(
                        value = filterName,
                        onValueChange = { filterName = it },
                        label = { Text(text = "Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        var isStatusExpanded by remember { mutableStateOf(false) }
                        var fieldSize by remember { mutableStateOf(Size(0f, 0f)) }
                        OutlinedTextField(
                            value = CharacterStatus.asList()[selectedStatusIndex].firstCaseName(),
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coord ->
                                    fieldSize = coord.size.toSize()
                                },
                            label = { Text(text = "Status") },
                            readOnly = true,
                            trailingIcon = {
                                Icon(Icons.Default.ArrowDropDown, contentDescription = String())
                            }
                        )
                        Spacer(
                            modifier = Modifier
                                .width(with(LocalDensity.current) { fieldSize.width.toDp() })
                                .height(with(LocalDensity.current) { fieldSize.height.toDp() })
                                .clickable { isStatusExpanded = true }
                        )
                        DropdownMenu(
                            expanded = isStatusExpanded,
                            onDismissRequest = { isStatusExpanded = false },
                            modifier = Modifier.width(
                                with(LocalDensity.current) {
                                    fieldSize.width.toDp()
                                }
                            )
                        ) {
                            CharacterStatus.asList().forEachIndexed { index, characterStatus ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = characterStatus.firstCaseName()
                                        )
                                    },
                                    onClick = {
                                        selectedStatusIndex = index
                                        isStatusExpanded = false
                                    }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = filterSpecie,
                        onValueChange = { filterSpecie = it },
                        label = { Text(text = "Species") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = filterType,
                        onValueChange = { filterType = it },
                        label = { Text(text = "Type") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        var isExpanded by remember { mutableStateOf(false) }
                        var fieldSize by remember { mutableStateOf(Size(0f, 0f)) }
                        OutlinedTextField(
                            value = CharacterGender.asList()[selectedGenderIndex].firstCaseName(),
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coord ->
                                    fieldSize = coord.size.toSize()
                                },
                            label = { Text(text = "Status") },
                            readOnly = true,
                            trailingIcon = {
                                Icon(Icons.Default.ArrowDropDown, contentDescription = String())
                            }
                        )
                        Spacer(
                            modifier = Modifier
                                .width(with(LocalDensity.current) { fieldSize.width.toDp() })
                                .height(with(LocalDensity.current) { fieldSize.height.toDp() })
                                .clickable { isExpanded = true }
                        )
                        DropdownMenu(
                            expanded = isExpanded,
                            onDismissRequest = { isExpanded = false },
                            modifier = Modifier.width(
                                with(LocalDensity.current) {
                                    fieldSize.width.toDp()
                                }
                            )
                        ) {
                            CharacterGender.asList().forEachIndexed { index, characterGender ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = characterGender.firstCaseName()
                                        )
                                    },
                                    onClick = {
                                        selectedGenderIndex = index
                                        isExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CharacterScreenFilterPreview() {
    CharacterScreenFilter()
}
