class Data_list_student_short(studentList: List<Student_short>) : Data_list<Student_short>(studentList) {

    override fun get_names(): List<String> {
        val attributes = listOf("№","FIO","git","contact")
        return attributes
    }
    override fun get_data(): MutableList<MutableList<Any?>> {
        var args= mutableListOf<MutableList<Any?>>()
        args.add(mutableListOf())
        var count =1
        for(row in orderedList)
        {
            args.add(mutableListOf(count,row.initials,row.git,row.contact))
            count++
        }
        return args
        
    }
}