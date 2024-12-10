fun main() {
    val userRepository = UserRepositoryImpl()

    val userService = UserService(userRepository)

    while (true) {
        println("\nДоступные действия:")
        println("1. Создать нового пользователя")
        println("2. Вывести список пользователей")
        println("3. Изменить роль пользователя")
        println("4. Удалить пользователя")
        println("5. Завершить работу")

        print("Выберите действие (1-5): ")
        val choice = readLine()?.toIntOrNull() ?: continue

        when (choice) {
            1 -> createNewUser(userService)
            2 -> listUsers(userService)
            3 -> changeUserRole(userService)
            4 -> deleteUser(userService)
            5 -> System.exit(0)
            else -> println("Неверный выбор. Попробуйте еще раз.")
        }
    }
}

fun createNewUser(userService: UserService) {
    print("Введите имя пользователя: ")
    val username = readLine() ?: return
    print("Введите адрес электронной почты: ")
    val email = readLine() ?: return

    userService.createUser(username, email)

}

fun listUsers(userService: UserService) {
    val users = userService.listUsers()
    if (users.isEmpty()) {
        println("Список пользователей пуст.")
    } else {
        println("Список пользователей:")
        users.forEach { user ->
            println("ID: ${user.id}, Username: ${user.username}, Email: ${user.email}, Role: ${user.role}")
        }
    }
}

fun changeUserRole(userService: UserService) {
    print("Введите ID пользователя: ")
    val userId = readLine()?.toLongOrNull() ?: return
    print("Выберите новую роль (0 - Пользователь, 1 - Администратор, 2 - Гость, 3 - Модератор): ")
    val newRole = readLine()?.toIntOrNull() ?: return

    val user = userService.getUser(userId)
    if (user != null) {
        val roles = listOf(UserRole.USER, UserRole.ADMIN, UserRole.GUEST, UserRole.MODERATOR)
        val newRoleEnum = roles[newRole!!]
        userService.promoteUser(user, newRoleEnum)
        println("Роль пользователя изменена на $newRoleEnum")
    } else {
        println("Пользователь не найден.")
    }
}

fun deleteUser(userService: UserService) {
    print("Введите ID пользователя для удаления: ")
    val userId = readLine()?.toLongOrNull() ?: return

    val deleted = userService.deleteUser(userId)
    if (deleted) {
        println("Пользователь успешно удален.")
    } else {
        println("Пользователь не найден для удаления.")
    }
}