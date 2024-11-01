import java.util.Scanner

// Интерфейс для всех типов уведомлений
interface Notification {
    fun send(message: String, recipient: String)
}

// Реализация отправки Email уведомлений
class EmailNotification : Notification {
    override fun send(message: String, recipient: String) {
        println("Отправка Email на $recipient: $message")
    }
}

// Реализация отправки SMS уведомлений
class SMSNotification : Notification {
    override fun send(message: String, recipient: String) {
        println("Отправка SMS на $recipient: $message")
    }
}

// Реализация отправки Push уведомлений
class PushNotification : Notification {
    override fun send(message: String, recipient: String) {
        println("Отправка Push уведомления на $recipient: $message")
    }
}

// Класс для хранения пользовательских предпочтений
data class UserPreferences(
    val prefersEmail: Boolean = false,
    val prefersSMS: Boolean = false,
    val prefersPush: Boolean = false
)

// Класс пользователя с его предпочтениями
data class User(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val pushId: String,
    val preferences: UserPreferences
)

// Система уведомлений, которая выбирает канал по предпочтениям пользователя
class NotificationSystem {
    private val emailNotification = EmailNotification()
    private val smsNotification = SMSNotification()
    private val pushNotification = PushNotification()

    // Отправка по предпочтениям пользователя
    fun sendNotification(user: User, message: String) {
        when {
            user.preferences.prefersEmail -> emailNotification.send(message, user.email)
            user.preferences.prefersSMS -> smsNotification.send(message, user.phoneNumber)
            user.preferences.prefersPush -> pushNotification.send(message, user.pushId)
            else -> println("Нет предпочитаемого метода уведомлений для ${user.name}. Уведомление не отправлено.")
        }
    }
    fun sendNotificationManually(user: User, message: String, method: String) {
        when (method.lowercase()) {
            "email" -> {
                if (user.preferences.prefersEmail) {
                    emailNotification.send(message, user.email)
                } else {
                    println("Пользователь ${user.name} не предпочитает уведомления по Email.")
                }
            }
            "sms" -> {
                if (user.preferences.prefersSMS) {
                    smsNotification.send(message, user.phoneNumber)
                } else {
                    println("Пользователь ${user.name} не предпочитает уведомления по SMS.")
                }
            }
            "push" -> {
                if (user.preferences.prefersPush) {
                    pushNotification.send(message, user.pushId)
                } else {
                    println("Пользователь ${user.name} не предпочитает уведомления по Push.")
                }
            }
            else -> println("Неверный выбранный метод.")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val notificationSystem = NotificationSystem()

    // Создаем пользователей с разными предпочтениями
    val user1 = User(
        name = "Александр",
        email = "alex@example.com",
        phoneNumber = "+375293172538",
        pushId = "alex_push_id",
        preferences = UserPreferences(prefersEmail = true)
    )
    val user2 = User(
        name = "Василий",
        email = "vas@example.com",
        phoneNumber = "+375296266348",
        pushId = "vas_push_id",
        preferences = UserPreferences(prefersSMS = true)
    )

    // Запрашиваем сообщение
    println("Введите сообщение для уведомления:")
    val message = scanner.nextLine()

    while (true) {
        println("\nВыберите опцию:")
        println("1. Отправить уведомление Александру автоматически")
        println("2. Отправить уведомление Василию автоматически")
        println("3. Отправить уведомление Александру вручную (выбор метода)")
        println("4. Отправить уведомление Василию вручную (выбор метода)")
        println("5. Выйти")

        when (scanner.nextLine()) {
            "1" -> notificationSystem.sendNotification(user1, message)
            "2" -> notificationSystem.sendNotification(user2, message)
            "3" -> {
                println("Выберите метод для Александра (email, sms, push):")
                val method = scanner.nextLine()
                notificationSystem.sendNotificationManually(user1, message, method)
            }
            "4" -> {
                println("Выберите метод для Василия (email, sms, push):")
                val method = scanner.nextLine()
                notificationSystem.sendNotificationManually(user2, message, method)
            }
            "5" -> {
                println("Выход из программы.")
                break
            }
            else -> println("Неверная опция. Пожалуйста, попробуйте снова.")
        }
    }
}
