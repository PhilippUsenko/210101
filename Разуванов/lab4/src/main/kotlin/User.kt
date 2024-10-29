data class User(
    val id: Long,
    var username: String,
    var email: String,
    var role: UserRole = UserRole.USER
)
