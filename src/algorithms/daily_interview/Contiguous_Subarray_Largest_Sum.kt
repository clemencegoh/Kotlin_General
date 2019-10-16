package algorithms.daily_interview

import java.lang.Integer.max

/*
You are given an array of integers. Find the maximum sum of all possible contiguous subarrays of the array.

Example:

[34, -50, 42, 14, -5, 86]

Given this input array, the output should be 137. The contiguous subarray with the largest sum is [42, 14, -5, 86].

Your solution should run in linear time.
 */

fun main(){
    val arr = arrayOf(34, -50, 42, 14, -5, 86)

    val c = Contiguous_Subarray_Largest_Sum()

    println(c.FindLargestSubarray(arr))
    println(c.showLargestSubarray(arr).contentToString())
}


class Contiguous_Subarray_Largest_Sum{
    fun FindLargestSubarray(arr: Array<Int>): Int {
        // Iterate through items in arr
        var highest = 0
        var tempSum = 0
        for (elem in arr){
            tempSum += elem
            highest = max(highest, tempSum)
            if (tempSum < 0){
                tempSum = 0 // reset
            }
        }
        return highest
    }

    fun showLargestSubarray(arr: Array<Int>): Array<Int> {
        var pointer1 = 0
        var pointer2 = 0
        var highest = 0
        var tempSum = 0
        for (i in arr.indices){
            tempSum += arr[i]
            if (tempSum > highest){
                highest = tempSum
                // mark this location
                pointer2 = i
            }
            if (tempSum < 0){
                if (i < arr.size - 1){
                    pointer1 = i + 1 // reset pointer
                }
                tempSum = 0
            }
        }
        return arr.copyOfRange(pointer1, pointer2 + 1)
    }

}