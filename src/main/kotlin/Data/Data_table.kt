package Data

class Data_table<T>(private val data: Array<Array<T>>) {

    fun getElement(row: Int, col: Int): T? {
        return if (row in data.indices && col in data[row].indices) {
            data[row][col]
        } else {
            null
        }
    }
    fun getRowCount(): Int {
        return data.size
    }
    fun getColumnCount(): Int {
        return if (data.isNotEmpty()) data[0].size else 0
    }
}