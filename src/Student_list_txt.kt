import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
class Student_list_txt: Student_list_super(),Student_list_interface{
    override fun read_from_file(address:String):MutableList<Student>{
        val file= File(address)
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

    override fun write_to_file(address:String) {
        File(address).printWriter().use { out ->
            list_data.forEach { message ->
                out.println(message.toString())
            }
        }
    }
}