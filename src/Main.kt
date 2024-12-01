object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val student1 = Student(1, "Иванов", "Иван", "Иванович")

        val optional = HashMap<String?, String?>()
        optional["phone"] = "+79001234567"
        optional["telegram"] = "@ivanov"

        val student2 = Student(2, "Петров", "Петр", "Петрович", optional)

        println(student1)
        println(student2)

        student1.setEmail("ivanov@example.com")
        student1.setGit("ivanov-git")
        println(student1)

        student2.setPhone("+79007654321")
        println(student2)
    }
}