class UserService(private val userRepository: UserRepository) {
    var counter = 0L;
    fun createUser(username: String, email: String): User {
        val user = User(counter++, username, email)
        userRepository.saveUser(user)
        return user
    }

    fun listUsers(): List<User> {
        return userRepository.listUsers()
    }

    fun getUser(id: Long): User? {
        return userRepository.getUser(id)
    }

    fun promoteUser(user: User, newRole: UserRole) {
        user.role = newRole
        userRepository.saveUser(user)
    }

    fun deleteUser(id: Long): Boolean {
        return userRepository.deleteUser(id)
    }
}