fun main() {
    println(firstFactorial(17))
}

// girdi 17 ve daha büyük bir tam sayı ise işlem sonucu Long değer döndürür.
private fun firstFactorial(num : Int) : Long {   
    var result = 1L
    for (i in 1..num) {
        result *= i.toLong()
    }
    return result
}