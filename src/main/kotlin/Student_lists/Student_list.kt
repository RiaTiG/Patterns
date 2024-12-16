import Data.Data_list
import SQL.Student_list_DB
import Student.Student
import Student.Student_short
import Student_lists.Student_list_JSON
import Student_lists.Student_list_YAML
import Student_lists.Student_list_txt
import Student_lists.Student_manager

interface Student_list_interface
{
    fun get_by_id(id:Int): Student?
    fun add_student(student:Student)
    fun update_student(student: Student,id:Int,)
    fun delete_student(id:Int)
    fun get_k_n_student_short_list(k: Int, n: Int) : Data_list<Student_short>
    fun get_count():Int
}
class Student_list_adapter(var path:String):Student_list_interface
{
    private var student_list: Student_manager? = null
    init {
        if (path.split('.')[1]=="txt")
            student_list= Student_manager(Student_list_txt())
        if (path.split('.')[1]=="json")
            student_list=Student_manager(Student_list_JSON())
        if (path.split('.')[1]=="yaml")
            student_list=Student_manager(Student_list_YAML())
        student_list?.read_from_file(path)
    }
    override fun get_by_id(id: Int): Student? {
        return student_list?.get_by_id(id)
    }
    override fun get_k_n_student_short_list(k: Int, n: Int): Data_list<Student_short> {
        return student_list?.get_k_n_student_short_list(k,n) ?:Data_list(mutableListOf())
    }
    override fun add_student(student: Student) {
        student_list?.add_student(student)
    }
    override fun update_student(student: Student,id: Int) {
        student_list?.update_student(id,student)
    }
    override fun delete_student(id: Int) {
        student_list?.delete_student(id)
    }
    override fun get_count(): Int {
        return student_list?.get_count()?:0
    }
}
class Student_list(path: String):Student_list_interface {
    private var student_list: Student_list_interface? = null
    init{
        if(path=="DataBase")
        {
            student_list=Student_list_DB.GetInstance()
        }
        else
        {
            student_list=Student_list_adapter(path)
        }
    }
    override fun get_by_id(id: Int): Student? {
        return student_list?.get_by_id(id)
    }
    override fun get_k_n_student_short_list(k: Int, n: Int): Data_list<Student_short> {
        return student_list?.get_k_n_student_short_list(k,n) ?:Data_list(mutableListOf())
    }
    override fun add_student(student: Student) {
        student_list?.add_student(student)
    }
    override fun update_student(student: Student,id: Int) {
        student_list?.update_student(student,id)
    }
    override fun delete_student(id: Int) {
        student_list?.delete_student(id)
    }
    override fun get_count(): Int {
        return student_list?.get_count()?:0
    }
}