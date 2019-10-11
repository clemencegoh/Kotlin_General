package algorithms.daily_interview

/*
There are n people lined up, and each have a height represented as an integer.
A murder has happened right in front of them, and only people who are taller than everyone
in front of them are able to see what has happened. How many witnesses are there?
Murder is on the right of the array (end).

Example:
Input: [3, 6, 3, 4, 1]
Output: 3
Explanation: Only [6, 4, 1] were able to see in front of them.
 */

fun main() {
    println(murderWitnesses(arrayOf(3,6,3,4,1)))
}

fun murderWitnesses(arr: Array<Int>): Int{
    // backwards iteration to determine max
    var current_max = arr[arr.size - 1]
    var count = 0
    for (i in arr.size - 1 downTo 0){
        if (arr[i] >= current_max){
            count += 1
            current_max = arr[i]
        }
    }

    return count
}