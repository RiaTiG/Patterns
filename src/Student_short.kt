class Student_short {
    var id: Int
    var initials: String
    var git: String
    var contact: String

    // Конструктор 1: принимает объект Student
    constructor(student: Student, id: Int) {
        this.id = id
        this.initials = "${student.lastName} ${student.firstName.first()}.${student.surname.first()}."
        this.git = student.git ?: "Гитхаб не указан"
        this.contact = when {
            student.phone != null -> "телефон: ${student.phone}"
            student.email != null -> "email: ${student.email}"
            student.telegram != null -> "Telegram: ${student.telegram}"
            else -> "контакты не указаны"
        }
    }

    // Конструктор 2: принимает ID и строку с информацией
    constructor(id: Int, data: String) {
        this.id = id
        val parts = data.split(";").map { it }
        this.initials = parts.getOrNull(0) ?: "Инициалов нет"
        this.git = parts.getOrNull(1) ?: "Гит не указан"
        this.contact = parts.getOrNull(2) ?: "Контакты не указаны"
    }

    override fun toString(): String {
        return "ID: $id, Фамилия Инициалы: $initials, Git: $git, Контакт: $contact"
    }
}