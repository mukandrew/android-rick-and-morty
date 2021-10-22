package academy.mukandrew.randm.common.utils

inline fun <reified T : Enum<T>> safeValueOf(type: String?, default: T): T {
    return try {
        java.lang.Enum.valueOf(T::class.java, type.orEmpty())
    } catch (e: Exception) {
        default
    }
}

inline fun <reified T : Enum<T>> safeValueOfOrNull(type: String?): T? {
    return try {
        java.lang.Enum.valueOf(T::class.java, type.orEmpty())
    } catch (e: Exception) {
        null
    }
}

inline fun <reified T : Enum<T>> getEnumFromIndex(index: Int, defaultIndex: Int = 0): T {
    val list = enumValues<T>()
    return if (index !in 0..list.lastIndex) list[defaultIndex] else list[index]
}
