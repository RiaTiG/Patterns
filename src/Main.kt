import Student

fun main() {
    val sam = Student("Иванов Иван Иванович;+79999999999;ivanov@example.com;@ivanov;https://github.com/ivanov")
    val bob = Student("Smith", "Bob", "John", _git = "https://github.com/RiaTiG");
    val list: MutableList<Student> = mutableListOf(bob)
    val list2: MutableList<Student>
    list2=Student.read_from_txt("src/students.txt")

//    val anna = Student("Smith", "Anna", "Helen", _phone = "+79891214092");
//    val tom = Student("Johnson", "Tom", "William", _phone = "+79891214092");
//    bob.validate()
//    bob.set_contact(_telegram = "@RiaTig")
//    val short1 = Student_short(sam)
//    println(short1)
    for (student in list2) {
        student.getStudent()
        student.getInfo()
    }
}