import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
class Student_list_txt {
    var list_data:MutableList<Student> = mutableListOf()

    fun read_from_txt(src:String):MutableList<Student>{
        val file= File(src)
        var list= mutableListOf<Student>()
        try{
            var lines=file.readLines()
            for (line in lines){
                list.add(Student(line))
            }
        }
        catch(e: FileNotFoundException){
            println("could not find file")
        }
        catch(e: IOException){
            println("could not read file")
        }
        list_data=list
        return list
    }

    fun write_to_txt(src:String,name:String,students:MutableList<Student>){
        val file= File(src+name)
        for(student in students) {
            file.writeText(student.toString())
        }
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
        require(n*k-1 in list_data.indices)
        val list_student = list_data.drop((k-1)*n).take(n)
        val short_list = list_student.map{Student_short(it)}
        return Data_list(short_list)
    }
}