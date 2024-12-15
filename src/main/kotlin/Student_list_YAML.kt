import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
class Student_list_YAML : Student_list_super(), Student_list_interface{
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