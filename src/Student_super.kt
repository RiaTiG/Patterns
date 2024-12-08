open class Student_super {
    var id: Int = 0
        get() {
            return field
        }
        set(value) {
            if (value > 0)
                field = value
        }
    companion object{
        var count=0
        val phoneReg = Regex("""^\+7\d{10}$|^8\d{10}$""")
        val emailReg = Regex("""^[\w.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$""")
        val nameReg = Regex("""^[А-Яа-яA-Za-z-]+$""")
        val telegramReg = Regex("""^@[A-Za-z0-9_]{3,}$""")
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
            return if (value != null && telegramReg.matches(value.toString())) {
                true
            } else {
                if (value != null)
                    println("Неправильный формат Telegram")
                    println(value)
                false
            }
        }

        fun checkEmail(value: String?): Boolean {
            return if (value != null && emailReg.matches(value.toString())) {
                true
            } else {
                if(value != null)
                    println("Неправильный формат Email")
                false
            }
        }

        fun checkGit(value: String?): Boolean {
            return if (value != null && gitReg.matches(value.toString())) {
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
}