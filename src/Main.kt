import Student

fun main() {
    val bob = Student("Smith", "Bob", "John", _phone = "+79891214092");
    val anna = Student("Smith", "Anna", "Helen", _phone = "89891214092");
    val tom = Student("Johnson", "Tom", "William", _phone = "9891214092");
    val list: MutableList<Student> = mutableListOf(bob, anna, tom)
    for (student in list) {
        student.getInfo()
    }
}