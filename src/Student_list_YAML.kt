import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
class Student_list_YAML {
    var list_data:MutableList<Student> = mutableListOf<Student>()
    fun read_from_yaml(address:String):MutableList<Student>{
        val yamlMapper = ObjectMapper(YAMLFactory())
        list_data=yamlMapper.readValue(File(address),yamlMapper.typeFactory.constructCollectionType(List::class.java, Student::class.java))
        return list_data
    }
    fun write_to_yaml(address:String)
    {
        val file = File(address)
        val yamlMapper = ObjectMapper(YAMLFactory())
        yamlMapper.writeValue(file, list_data)
    }
    fun get_by_id(id:Int):Student?
    {
        for(student in list_data)
        {
            if(student.id==id)
            {
                return student
            }
        }
        return null
    }

    fun get_k_n_student_short_list(k:Int,n:Int):Data_list<Student_short>{
        val student_list = list_data.drop((k-1)*n).take(n)
        val short_list = student_list.map{Student_short(it)}
        for(student in student_list){
            student.GetInfo()
        }
        return Data_list(short_list)
    }
    fun sortByName(list: MutableList<Student>) {
        list_data.sortBy { it.GetFIO() }
//        for(student in list_data){
//            student.getInfo()
//        }
    }
    fun add_student(student: Student){
        if(list_data.size>0)
            student.id=list_data.maxOf{it.id}+1
        list_data.add(student)
    }

    fun change_id(id:Int,student: Student){
        var st=get_by_id(id)
        if(st!=null){
            var i=list_data.indexOf(st)
            student.id=id
            list_data[i]=student}
        else{
            println("could not find student with id")
        }
    }
    fun delete_id(id:Int){
        var st=get_by_id(id)
        if(st!=null){
            var i=list_data.indexOf(st)
            list_data.removeAt(i)
        }
        else{
            println("could not find student with id")
        }
    }
    fun get_student_short_count():Int{
        return list_data.size
    }
}