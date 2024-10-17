package roles

class Moderator(
    override val username: String,
    override val age: Int?,
    override val email: String
) : UserRole {

    override fun viewContent(): String {
        return "$username (Age: ${age ?: "not provided"}, Email: $email): Viewing and moderating content as a moderator."
    }

    override fun editContent(): String {
        return "$username: Editing limited content as a moderator."
    }
}
