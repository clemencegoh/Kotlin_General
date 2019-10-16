package algorithms.daily_interview

import kotlin.math.max

/*
You are given an array. Each element represents the price of a stock on that particular day. Calculate and return the maximum profit you can make from buying and selling that stock only once.

For example: [9, 11, 8, 5, 7, 10]

Here, the optimal trade is to buy when the price is 5, and sell when it is 10, so the return value should be 5 (profit = 10 - 5 = 5).

 */

fun main(){
    val arr = arrayOf(9, 11, 8, 5, 7, 10)
    val arr2 = arrayOf(10, 2, 5, 7, 4, 8)
    val arr3 = arrayOf(20, 19, 15, 10, 5, 2, 1)
    val arr4 = arrayOf(20, 19, 15, 10, 5, 7, 2, 1)

    val s = Simple_Max_Profit_Stocks()

    println(s.getMaxProfits(arr))   // 5
    println(s.getMaxProfits(arr2))  // 6
    println(s.getMaxProfits(arr3))  // 0
    println(s.getMaxProfits(arr4))  // 2
}


class Simple_Max_Profit_Stocks {
    fun getMaxProfits(arr: Array<Int>): Int {
        // find ascending pattern
        var minNum = arr[0]
        var maxDiff = 0
        for (i in arr.indices){
            if (arr[i] < minNum){
                minNum = arr[i]  // any big number from here takes ref from this pos
            }
            if (arr[i] > minNum){
                maxDiff = max(maxDiff, arr[i] - minNum)
            }
        }

        return maxDiff
    }
}