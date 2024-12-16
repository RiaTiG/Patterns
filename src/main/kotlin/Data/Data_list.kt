package Data

open class Data_list<T>(val orderedList: List<T>) {

    private val selectedElements = mutableSetOf<Int>()

    open fun select(number: Int) {
        if (number in orderedList.indices) selectedElements.add(number)
    }
    open fun get_selected(): List<Int> {
        return selectedElements.toList()
    }
    open fun get_names(): List<String> {
        throw NotImplementedError("Метод get_names должен быть реализован в подклассе")
    }
    open fun get_data(): MutableList<MutableList<Any?>> {
        throw NotImplementedError("Метод get_data должен быть реализован в подклассе")
    }
    fun getRawList(): List<T> {
        return orderedList
    }
}