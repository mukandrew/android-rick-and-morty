package academy.mukandrew.randm.cache.converters

import androidx.room.TypeConverter

internal class IdTypeConverter {
    private companion object {
        private const val SPLIT_PATTERN = ","
    }

    @TypeConverter
    fun fromListId(value: List<Long>): String {
        return value.joinToString(SPLIT_PATTERN) { it.toString() }
    }

    @TypeConverter
    fun toListId(value: String): List<Long> {
        return value.split(SPLIT_PATTERN).map { it.toLong() }
    }
}
