package roles

class Guest : UserRole {

    override val username: String = "Guest"
    override val age: Int? = null
    override val email: String = ""

    override fun viewContent(): String {
        return "Guest (Age: not provided, Email: not provided): Viewing limited content as a guest."
    }

    override fun editContent(): String {
        return "Guest: Guests cannot edit content."
    }
}
