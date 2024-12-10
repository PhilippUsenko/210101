package roles

class Moderator(
    override val username: String,
    override val age: Int?,
    override val email: String
) : UserRole {

    override fun viewContent(): String {
        return "$username (Возраст: ${age ?: "не указан"}, Электронная почта: $email): Просматривает и модерирует контент как модератор."
    }

    override fun editContent(): String {
        return "$username: Редактирует ограниченный контент как модератор."
    }
}
