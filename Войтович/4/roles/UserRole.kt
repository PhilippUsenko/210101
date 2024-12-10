package roles

interface UserRole {
    val username: String
    val age: Int?
    val email: String

    fun viewContent(): String
    fun editContent(): String
}
