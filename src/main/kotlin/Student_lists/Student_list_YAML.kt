package Student_lists

import Student.Student
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import java.io.File

class Student_list_YAML : Student_list_super(), Strategy_interface {
    override fun read_from_file(address:String):MutableList<Student>{
        val yamlMapper = ObjectMapper(YAMLFactory())
        list_data=yamlMapper.readValue(File(address),yamlMapper.typeFactory.constructCollectionType(List::class.java, Student::class.java))
        return list_data
    }
    override fun write_to_file(address:String)
    {
        val file = File(address)
        val yamlMapper = ObjectMapper(YAMLFactory())
        yamlMapper.writeValue(file, list_data)
    }

}