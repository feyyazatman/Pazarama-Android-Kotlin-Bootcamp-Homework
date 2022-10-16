
fun main() {
    println(usernameValidation("u_hello_world123"))
}

private fun usernameValidation(str : String?)  : String {
    val firstChar = str?.get(0)
    val lastChar = str?.get(str.length - 1)
    val regex = Regex("^[a-zA-Z0-9_]+$") // girilen string değerinin neler içereceği belirleniyor.
    val regControl = str?.let { regex.matches(it) } // istediğimiz formatta mı kontrol sağlanıyor.

    return if (str != null) {
        if (str.length in 4..25) {
            if (firstChar!!.isLetter()) {
                if (lastChar != '_') {
                    if (regControl!!) {
                        "true"
                    } else "false"
                } else "false"
            } else "false"
        } else "false"
    } else "false"
}