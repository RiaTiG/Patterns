import java.util.*

class Student(id: Int, lastName: String, firstName: String, patronymic: String) {
    // Геттеры
    val id: Int
    val lastName: String
    val firstName: String
    val patronymic: String
    var phone: Optional<String> = Optional.empty()
        private set
    var telegram: Optional<String> = Optional.empty()
        private set
    var email: Optional<String> = Optional.empty()
        private set
    var git: Optional<String> = Optional.empty()
        private set

    // Основной конструктор с обязательными полями
    init {
        require(!(id <= 0 || lastName == null || firstName == null || patronymic == null)) { "ID и ФИО должны быть заданы корректно." }
        this.id = id
        this.lastName = lastName
        this.firstName = firstName
        this.patronymic = patronymic
    }

    // Вторичный конструктор с использованием HashMap
    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        patronymic: String,
        optionalFields: Map<String?, String?>
    ) : this(id, lastName, firstName, patronymic) {
        optionalFields.forEach { (key: String?, value: String?) ->
            when (key!!.lowercase(Locale.getDefault())) {
                "phone" -> this.phone = Optional.ofNullable(value)
                "telegram" -> this.telegram = Optional.ofNullable(value)
                "email" -> this.email = Optional.ofNullable(value)
                "git" -> this.git = Optional.ofNullable(value)
                else -> throw IllegalArgumentException("Неизвестное поле: $key")
            }
        }
    }

    fun setPhone(phone: String?) {
        this.phone = Optional.ofNullable(phone)
    }

    fun setTelegram(telegram: String?) {
        this.telegram = Optional.ofNullable(telegram)
    }

    fun setEmail(email: String?) {
        this.email = Optional.ofNullable(email)
    }

    fun setGit(git: String?) {
        this.git = Optional.ofNullable(git)
    }

    override fun toString(): String {
        return "Student{" +
                "ID=" + id +
                ", Фамилия='" + lastName + '\'' +
                ", Имя='" + firstName + '\'' +
                ", Отчество='" + patronymic + '\'' +
                ", Телефон=" + phone.orElse("не указан") +
                ", Телеграм=" + telegram.orElse("не указан") +
                ", Почта=" + email.orElse("не указана") +
                ", Гит=" + git.orElse("не указан") +
                '}'
    }
}