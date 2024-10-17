package roles

class User(
    override val username: String,
    override val age: Int?,
    override val email: String
) : UserRole {

    constructor(username: String, email: String) : this(username, null, email)

    constructor(username: String) : this(username, null, "no-email@example.com")

    override fun viewContent(): String {
        return "$username (Age: ${age ?: "not provided"}, Email: $email): Viewing content as a regular user."
    }

    override fun editContent(): String {
        return "$username: You don't have permission to edit content."
    }
}
