import Student

fun main() {
    val bob = Student("Smith", "Bob", "John", _git = "https://github.com/RiaTiG");
    val anna = Student("Smith", "Anna", "Helen", _phone = "+79891214092");
    val tom = Student("Johnson", "Tom", "William", _phone = "+79891214092");
    val list: MutableList<Student> = mutableListOf(bob, anna, tom)
    bob.validate()
    bob.set_contact(_telegram = "@RiaTig")
    for (student in list) {
        student.getInfo()
    }
}