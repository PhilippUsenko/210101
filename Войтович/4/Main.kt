import roles.*

fun main() {
    var user1: UserRole = User("User")
    var user2: UserRole = Guest()
    var user3: UserRole = Moderator("ModUser", 35, "mod@example.com")

    val admin: Admin = Admin("AdminUser", 40, "admin@example.com")

    println(user1.viewContent())
    println(user1.editContent())
    println()

    user1 = admin.changeUserRole(user1, Moderator(user1.username, user1.age, user1.email))
    println(user1.viewContent())
    println(user1.editContent())
    println()

    user2 = admin.changeUserRole(user2, User("GuestToUser", 30, "asd@gmail.com"))
    println(user2.viewContent())
    println(user2.editContent())
    println()

    user3 = admin.changeUserRole(user3, Guest())
    println(user3.viewContent())
    println(user3.editContent())
}
