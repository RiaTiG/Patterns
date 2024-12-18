
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
class ParsingException(message: String) : Exception(message)
class ValidationException(message: String) : Exception(message)

class Student: Student_super {

    @field:JsonProperty("lastName") var lastName: String = ""
        get() {
            return field
        }
        set(value) {
            if (checkFio(value))
                field = value
        }

    @field:JsonProperty("firstName") var firstName: String = ""
        get() {
            return field
        }
        set(value) {
            if (checkFio(value))
                field = value
        }

    @field:JsonProperty("surname") var surname: String = ""
        get() {
            return field
        }
        set(value) {
            if (checkFio(value))
                field = value
        }

    @field:JsonProperty("phone") var phone: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkPhone(value))
                field = value
        }

    @field:JsonProperty("telegram") var telegram: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkTelegram(value))
                field = value
        }

    @field:JsonProperty("email") var email: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkEmail(value))
                field = value
        }

    @field:JsonProperty("git") var git: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkGit(value))
                field = value
        }

    fun GetInfo(): String {
        val initials = GetInitials()
        val gitInfo = GetGitInfo()
        val contactInfo = GetContactInfo()
        println("$lastName $initials; $gitInfo; $contactInfo")
        return "$lastName $initials; $gitInfo; $contactInfo"
    }

    // Получение инициалов
    private fun GetInitials(): String {
        val firstInitial = firstName.firstOrNull() ?: '?'
        val surnameInitial = surname.firstOrNull() ?: '?'
        return "$firstInitial.$surnameInitial."
    }

    // Формирование информации по Git
    private fun GetGitInfo(): String {
        return git ?: "Гитхаб не указан"
    }
    fun GetFIO(): String {
        val initials = GetInitials()
        val gitInfo = GetGitInfo()
        val contactInfo = GetContactInfo()
        return "$lastName $initials; $gitInfo; $contactInfo"
    }
    // Формирование строки для средства связи
    private fun GetContactInfo(): String {
        return when {
            phone != null -> "телефон: $phone"
            email != null -> "email: $email"
            telegram != null -> "Telegram: $telegram"
            else -> "контакты не указаны"
        }
    }

    //конструктор, принимающий на вход строку, парсит ее
    constructor(inputString: String) {
        val parts = inputString.split(";")
        id = count
        if (parts.size < 1 || parts.size > 5) {
            throw ParsingException("Неверный формат строки: $inputString")
        }

        val nameParts = parts[0].split(" ")
        if (nameParts.size != 3) {
            throw ParsingException("ФИО должно содержать три слова: Фамилия Имя Отчество")
        }
        if (!checkFio(nameParts[0]) || !checkFio(nameParts[1]) || !checkFio(nameParts[2])) {
            throw ValidationException("ФИО содержит недопустимые символы")
        }
        lastName = nameParts[0]
        firstName = nameParts[1]
        surname = nameParts[2]

        if (parts.size > 1) phone = parts[1].ifBlank { null }
        if (parts.size > 2) email = parts[2].ifBlank { null }
        if (parts.size > 3) telegram = parts[3].ifBlank { null }
        if (parts.size > 4) git = parts[4].ifBlank { null }

        isValidContact()
    }
    // Валидация контактов для конструктора строки
    private fun isValidContact() {
        if (phone != null && !checkPhone(phone)) {
            throw ValidationException("Телефонный номер некорректен: $phone")
        }
        if (email != null && !checkEmail(email)) {
            throw ValidationException("Email некорректен: $email")
        }
        if (telegram != null && !checkTelegram(telegram)) {
            throw ValidationException("Telegram-аккаунт некорректен: $telegram")
        }
        if (git != null && !checkGit(git)) {
            throw ValidationException("GitHub URL некорректен: $git")
        }
    }

    //метод для установки контактов
    fun Set_contact(_email: String?=null, _phone: String?=null, _telegram: String?=null){
        if(checkEmail(_email))
            this.email = _email
        if(checkPhone(_phone))
            this.phone = _phone
        if(checkTelegram(_telegram))
            this.telegram = _telegram
    }

    fun validate():Boolean{
        if(checkGit(this.git)&&(checkPhone(this.phone) || checkEmail(this.email)|| checkTelegram(this.telegram))){
            println("Валидация пройдена")
            return true
        }
        else
            println("Валидация не пройдена")
        return false
    }
    @JsonCreator
    constructor(
        @JsonProperty("id") _id: String = "",
        @JsonProperty("lastName") _lastName: String = "",
        @JsonProperty("firstName")  _firstName: String = "",
        @JsonProperty("surname")  _surname: String = "",
        @JsonProperty("phone")  _phone: String? = null,
        @JsonProperty("email")  _email: String? = null,
        @JsonProperty("telegram")  _telegram: String? = null,
        @JsonProperty("git") _git: String? = null)
    {
        id=_id.toInt()
        lastName=_lastName
        firstName=_firstName
        surname=_surname
        phone=_phone
        email=_email
        telegram=_telegram
        git=_git
    }
//    constructor(_lastName: String, _firstName: String, _surname: String) {
//        lastName = _lastName
//        firstName = _firstName
//        surname = _surname
//    }

    constructor(_lastName: String, _firstName: String, _surname: String,
                _phone: String? = null, _telegram: String? = null, _email: String? = null, _git: String? = null
    ) {
        id = count
        lastName = _lastName
        firstName = _firstName
        surname = _surname
        phone = _phone
        telegram = _telegram
        email = _email
        git = _git
    }

    constructor(infoHash: HashMap<String, Any?>) {
        id = count
        lastName = infoHash["lastName"].toString()
        firstName = infoHash["firstName"].toString()
        surname = infoHash["surname"].toString()
        phone = infoHash.getOrDefault("phone", null).toString()
        telegram = infoHash.getOrDefault("telegram", null).toString()
        email = infoHash.getOrDefault("email", null).toString()
        git = infoHash.getOrDefault("git", null).toString()
    }

    fun GetStudent() {
        print("Id: $id, Фамилия: $lastName, Имя: $firstName, Отчество: $surname")
        if (phone != null)
            print(", Телефон: $phone")
        if (telegram != null)
            print(", Телеграм: $telegram")
        if (email != null)
            print(", Почта: $email")
        if (git != null)
            print(", Git: $git")
        println()
    }
}