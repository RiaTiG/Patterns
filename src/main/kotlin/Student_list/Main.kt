package Student_list

import SQL.Student_list_DB
import SQL.Student_list_DB.Companion.GetInstance
import Student.Student

fun main() {
//    val boba= Student("Иванов Иван Иванович;+79999999999;ivanov@example.com;@ivanov;https://github.com/ivanov")
//    val anna= Student("Ганс Йохан Игаев;+79999999999;iov@example.com;@iov;https://github.com/iov")
//    val biba= Student("Спиридонов Данил Игоревич;+79999999999;daniil@example.com;@daniil;https://github.com/daniil")
//    val tom= Student("Иванов Иван Иванович;+79999999999;ivanov@example.com;@ivanov;https://github.com/ivanov")

//
//    var st=Student("Ivanov Iohan Igorevich;+79891214082;@ivanov;ivanov@example.com;https://github.com/ivanov")
    var mem= GetInstance()
    mem.get_k_n_student_short_list(3,2)
    mem.get_by_id(1)
    mem.get_count()


//    val manager = Student_manager(Student_list_JSON())
//    manager.add_student(anna)
//    manager.read_from_file("src/output/json.json")
//    manager.write_to_file("src/output/json2.json")
//    manager.set_strategy(Student_list_txt())
//    manager.read_from_file("src/output/txt.txt")
//    manager.write_to_file("src/output/txt2.txt")
//    manager.set_strategy(Student_list_YAML())
//    manager.read_from_file("src/output/yaml.yaml")
//    manager.write_to_file("src/output/yaml2.yaml")

//    var mem=Student_list.Student_list_YAML()
//    mem.read_from_file("src/main/kotlin/out/yaml.yaml")
//    mem.add_student(tom)
//    mem.add_student(boba)
//    mem.add_student(biba)
//    mem.add_student(anna)
//    println(mem.get_student_short_count())
//    mem.write_to_file("src/main/kotlin/out/yaml.yaml")





//    val mem=Student_list_JSON()
//    mem.read_from_file("src/main/kotlin/json.json")
//    mem.add_student(tom)
//    mem.add_student(boba)
//    mem.add_student(biba)
//    mem.add_student(anna)
//    println(mem.get_student_short_count())
//    mem.write_to_file("src/main/kotlin/json.json")
//    mem.get_k_n_student_short_list(2,2)







//    val mem = Student_list.Student_list_txt()
//    mem.add_student(tom)
//    mem.change_id(3,tom)
//    mem.delete_id(3)
//    println(mem.get_student_short_count())
//    mem.get_by_id(3)?.getStudent()
//    mem.get_k_n_student_short_list(2,3)
//    val list = mem.read_from_txt("src/students.txt")
//    mem.sortByName(list)





















//    val sam = Student("Иванов Иван Иванович;+79999999999;ivanov@example.com;@ivanov;https://github.com/ivanov")
//    val bob = Student("Smith", "Bob", "John", _git = "https://github.com/RiaTiG");
//    val list: MutableList<Student> = mutableListOf(bob)
//    val list2: Student? = Student_list.Student_list_txt().get_by_id(0,"src/students.txt")
//    write_to_txt("src/students.txt", list2)
//    val anna = Student("Smith", "Anna", "Helen", _phone = "+79891214092");
//    val tom = Student("Johnson", "Tom", "William", _phone = "+79891214092");
//    bob.validate()
//    bob.set_contact(_telegram = "@RiaTig")
//    val short1 = Student.Student_short(sam)
//    println(short1)
//    val table = Data_list.Data_table(arrayOf(
//        arrayOf(1, "Smith", "Bob", "John"),
//        arrayOf(2, "Ольга", 30),
//        arrayOf(3, "Иван", 28)
//    ))
//    val new_bob=Student.Student_short(bob)
//    val new_anna=Student.Student_short(anna)
//    val listShort= listOf(new_bob,new_anna)
//    val newShortList=Data_list.Data_list_student_short(listShort)
//    println(newShortList.get_names())
//    println(newShortList.get_data())

    // Получение элемента
//    println(table.getElement(1, 1))
//    println(table.getElement(2, 0))


//    println("Количество строк: ${table.getRowCount()}") // 4
//
//
//    println("Количество столбцов: ${table.getColumnCount()}") // 3

//    for (student in list2) {
//        student.getStudent()
//        student.getInfo()
//    }
}