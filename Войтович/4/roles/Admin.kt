package roles

class Admin(
    override val username: String,
    override val age: Int?,
    override val email: String
) : UserRole {

    override fun viewContent(): String {
        return "$username (Age: ${age ?: "not provided"}, Email: $email): Viewing all content as an admin."
    }

    override fun editContent(): String {
        return "$username: Editing content as an admin."
    }

    fun changeUserRole(user: UserRole, newRole: UserRole): UserRole {
        println("$username: Changing role of ${user.username} to ${newRole::class.simpleName}")
        return newRole
    }
}
