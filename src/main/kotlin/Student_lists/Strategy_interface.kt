package Student_lists

import Student.Student

interface Strategy_interface {
    var list_data:MutableList<Student>
    fun write_to_file(address: String)
    fun read_from_file(address: String): MutableList<Student>
}
class Student_manager(private var strategy: Strategy_interface) : Student_list_super(){
    fun set_strategy(strategy: Strategy_interface) {
        strategy.list_data=this.strategy.list_data
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