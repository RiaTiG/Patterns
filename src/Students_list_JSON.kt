import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class Student_list_JSON {
    var list_data:MutableList<Student> = mutableListOf<Student>()
    fun read_from_json(address:String):MutableList<Student>{
        val listType = object : TypeToken<MutableList<Student>>() {}.type
        var gson = Gson()
        val file= File(address)
        try{
            list_data = gson.fromJson(address,listType) ?: mutableListOf()
        }
        catch(e: FileNotFoundException){
            println("could not find file")
        }
        catch(e: IOException){
            println("could not read file")
        }
        return list_data
    }
    fun write_to_json(address:String)
    {
        var gson = Gson()
        var json = gson.toJson(list_data)
        println(list_data)
        println(json)
        val file = File(address)
        file.writeText(json)
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
            student.getInfo()
        }
        return Data_list(short_list)
    }
    fun sortByName(list: MutableList<Student>) {
        list_data.sortBy { it.getFIO() }
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