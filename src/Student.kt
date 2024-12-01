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
            field = value
        }
    var firstName: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var surname: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var phone: String? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var telegram: String? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var email: String? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var git: String? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }

    constructor(_lastName: String, _firstName: String, _surname: String) {
        lastName = _lastName
        firstName = _firstName
        surname = _surname
    }

    constructor(
        _id: Int = 0, _lastName: String, _firstName: String, _surname: String,
        _phone: String? = null, _telegram: String? = null, _email: String? = null, _git: String? = null
    ) {
        id = _id
        lastName = _lastName
        firstName = _firstName
        surname = _surname
        phone = _phone
        telegram = _telegram
        email = _email
        git = _git
    }

    constructor(infoHash: HashMap<String, Any?>) {
        id = infoHash["id"] as Int
        lastName = infoHash["lastName"].toString()
        firstName = infoHash["firstName"].toString()
        surname = infoHash["surname"].toString()
        phone = infoHash.getOrDefault("phone", null).toString()
        telegram = infoHash.getOrDefault("telegram", null).toString()
        email = infoHash.getOrDefault("email", null).toString()
        git = infoHash.getOrDefault("git", null).toString()
    }

    fun getInfo() {
        print("ID: $id, Фамилия: $lastName, Имя: $firstName, Отчество: $surname")
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