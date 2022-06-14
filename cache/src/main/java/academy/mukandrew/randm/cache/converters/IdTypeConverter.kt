package academy.mukandrew.randm.cache.converters

import androidx.room.TypeConverter

internal class IdTypeConverter {
    private companion object {
        private const val SPLIT_PATTERN = ","
    }

    @TypeConverter
    fun fromListId(value: List<Int>): String {
        return value.joinToString(SPLIT_PATTERN) { it.toString() }
    }

    @TypeConverter
    fun toListId(value: String): List<Int> {
        return value.split(SPLIT_PATTERN).map { it.toInt() }
    }
}
