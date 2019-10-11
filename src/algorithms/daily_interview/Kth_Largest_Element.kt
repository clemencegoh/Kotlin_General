package algorithms.daily_interview

/*
Given a list, find the k-th largest element in the list.
Input: list = [3, 5, 2, 4, 6, 8], k = 3
Output: 5
 */

// todo: Complete this faster than n log n

fun main(){
    // driver code
    val arr = arrayOf(3, 5, 2, 4, 6, 8)  // should be 5
    val number = 3

    println(inefficientFindingKthElement(arr, number))
}

fun findKthLargest(arr: Array<Int>, k: Int): Int{
    // ?? Is this not possible in n time?

    return 1
}

fun inefficientFindingKthElement(arr: Array<Int>, k: Int): Int {
    // easy way, nLogn time complexity, sort first
    val newArray = arr.sortedArray()
    return newArray[arr.size - k]
}


