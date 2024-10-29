class UserRepositoryImpl : UserRepository {
    private val users = mutableMapOf<Long, User>()

    override fun saveUser(user: User) {
        if (!users.values.any { it.email == user.email || it.username == user.username }) {
            users[user.id] = user
            println("Пользователь создан: ${user.username}, ID: ${user.id}")
        } else {
            println("Пользователь с таким именем или почтой уже создан")
        }
    }

    override fun listUsers(): List<User> {
        return users.values.toList()
    }

    override fun getUser(id: Long): User? {
        return users[id]
    }

    override fun deleteUser(id: Long): Boolean {
        return users.remove(id) != null
    }
}