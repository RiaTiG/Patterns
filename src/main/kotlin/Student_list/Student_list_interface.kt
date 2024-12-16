package Student_list

import Student.Student

interface Student_list_interface {
    var list_data:MutableList<Student>
    fun write_to_file(address: String)
    fun read_from_file(address: String): MutableList<Student>
}
class Student_manager(private var strategy: Student_list_interface) : Student_list_super(){
    fun set_strategy(strategy: Student_list_interface) {
        this.strategy = strategy
    }
    fun read_from_file(address: String){
        strategy.read_from_file(address)
        this.list_data=strategy.list_data
    }
    fun write_to_file(address: String){
        this.list_data=strategy.list_data
        strategy.write_to_file(address)
    }
}