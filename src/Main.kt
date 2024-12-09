import Student_list_txt
fun main() {
    val mem = Student_list_txt()
    mem.read_from_txt("src/students.txt")

    //mem.get_by_id(2)?.getStudent()
    mem.get_k_n_student_short_list(2,3)
//    val sam = Student("Иванов Иван Иванович;+79999999999;ivanov@example.com;@ivanov;https://github.com/ivanov")
//    val bob = Student("Smith", "Bob", "John", _git = "https://github.com/RiaTiG");
//    val list: MutableList<Student> = mutableListOf(bob)
//    val list2: Student? = Student_list_txt().get_by_id(0,"src/students.txt")
//    write_to_txt("src/students.txt", list2)
//    val anna = Student("Smith", "Anna", "Helen", _phone = "+79891214092");
//    val tom = Student("Johnson", "Tom", "William", _phone = "+79891214092");
//    bob.validate()
//    bob.set_contact(_telegram = "@RiaTig")
//    val short1 = Student_short(sam)
//    println(short1)
//    val table = Data_table(arrayOf(
//        arrayOf(1, "Smith", "Bob", "John"),
//        arrayOf(2, "Ольга", 30),
//        arrayOf(3, "Иван", 28)
//    ))
//    val new_bob=Student_short(bob)
//    val new_anna=Student_short(anna)
//    val listShort= listOf(new_bob,new_anna)
//    val newShortList=Data_list_student_short(listShort)
//    println(newShortList.get_names())
//    println(newShortList.get_data())

    // Получение элемента
//    println(table.getElement(1, 1)) // "Антон"
//    println(table.getElement(2, 0)) // 2

    // Получение количества строк
//    println("Количество строк: ${table.getRowCount()}") // 4
//
//    // Получение количества столбцов
//    println("Количество столбцов: ${table.getColumnCount()}") // 3

//    for (student in list2) {
//        student.getStudent()
//        student.getInfo()
//    }
}