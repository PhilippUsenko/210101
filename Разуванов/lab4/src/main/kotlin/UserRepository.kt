interface UserRepository {
    fun saveUser(user: User)
    fun listUsers(): List<User>
    fun getUser(id: Long): User?
    fun deleteUser(id: Long): Boolean
}