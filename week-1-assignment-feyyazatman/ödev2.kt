
fun main() {
    val arr = arrayOf(1000000001,1000000002,1000000003,1000000004,1000000005)
    println(aVeryBigSum(arr))
}

private fun aVeryBigSum(arr : Array<Int>) : Long {
    var sum = 0L
    for (element in arr) {
        sum += element
    }
    return sum
}

