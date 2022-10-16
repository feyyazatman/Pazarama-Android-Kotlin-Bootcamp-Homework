fun main() {
   println( questionMarks("???7?sss??1rr5???5"))
}

private fun questionMarks(str: String): String {
    var result = "false"
    var questionMarks = 0
    var lastDigit = 0

    for (i in str) {
        if (i.isDigit()) {
            val digit = i.toString().toInt()
            val sum = digit + lastDigit
            lastDigit = digit
            if (sum != 10) {
                questionMarks = 0
            }
            if (questionMarks == 3) {
                result = "true"
                break // questionMarks sayısı 3 ve sum 10' a eşit ise fonk. devam etmesini gerek kalmaz.
            } else {
                result = "false"
            }
            questionMarks = 0
        } else if (i.toString() == "?") {
            questionMarks += 1
        }
    }
    return result
}