class Student {

    var id: Int = 0
        get() {
            return field
        }
        set(value) {
            if (value > 0)
                field = value
        }

    var lastName: String = ""
        get() {
            return field
        }
        set(value) {
            if (checkFio(value))
                field = value
        }

    var firstName: String = ""
        get() {
            return field
        }
        set(value) {
            if (checkFio(value))
                field = value
        }

    var surname: String = ""
        get() {
            return field
        }
        set(value) {
            if (checkFio(value))
                field = value
        }

    var phone: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkPhone(value))
                field = value
        }

    var telegram: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkTelegram(value))
                field = value
        }

    var email: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkEmail(value))
                field = value
        }

    var git: String? = null
        get() {
            return field
        }
        set(value) {
            if (checkGit(value))
                field = value
        }

    fun set_contact(_email: String?=null, _phone: String?=null, _telegram: String?=null){
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

    companion object{
        var count=0
        val phoneReg = Regex("""^\+7\d{10}$|^8\d{10}$""")
        val emailReg = Regex("""^[\w.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$""")
        val nameReg = Regex("""^[А-Яа-яA-Za-z-]+$""")
        val telegramReg = Regex("""^@[A-Za-z0-9_]{5,}$""")
        val gitReg = Regex("""^(https:\/\/|http:\/\/)?(www\.)?github\.com\/[A-Za-z0-9_.-]+\/?$""")

        fun checkPhone(value: String?):Boolean {
            if(phoneReg.matches(value.toString())) {
                return true
            }else {
                if (value != null)
                    println("Неправильный формат номера телефона")
                return false
            }
        }

        fun checkFio(value: String):Boolean {
            if (nameReg.matches(value)){
                return true
            }else {
                    println("Неправильный формат ФИО")
                return false
            }
        }

        fun checkTelegram(value: String?): Boolean {
            return if (telegramReg.matches(value.toString())) {
                true
            } else {
                if (value != null)
                    println("Неправильный формат Telegram")
                false
            }
        }

        fun checkEmail(value: String?): Boolean {
            return if (emailReg.matches(value.toString())) {
                true
            } else {
                if(value != null)
                        println("Неправильный формат Email")
                false
            }
        }

        fun checkGit(value: String?): Boolean {
            return if (gitReg.matches(value.toString())) {
                true
            } else {
                if (value != null)
                    println("Неправильный формат GitHub URL")
                false
            }
        }
    }
    init {
        count++
    }

    constructor(_lastName: String, _firstName: String, _surname: String) {
        lastName = _lastName
        firstName = _firstName
        surname = _surname
    }

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

    fun getInfo() {
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