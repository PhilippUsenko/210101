package roles

class Guest : UserRole {

    override val username: String = "Гость"
    override val age: Int? = null
    override val email: String = ""

    override fun viewContent(): String {
        return "$username (Возраст: не указан, Электронная почта: не указана): Просматривает ограниченный контент как гость."
    }

    override fun editContent(): String {
        return "$username: Гости не могут редактировать контент."
    }
}
