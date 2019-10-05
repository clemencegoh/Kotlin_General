package algorithms.leetcode

import kotlin.collections.*

fun TwoSum(arr: List<Int>, num: Int): ArrayList<Array<Int>>{
    // List all possible combinations in arr which add up to num
    var ReturnList = ArrayList<Array<Int>>()
    var temp_storage = HashMap<Int, Int>()
    for (item in arr){
        if (temp_storage.contains(item)){
            ReturnList.add(arrayOf(item, temp_storage[item]!!))
        }else{
            temp_storage[num - item] = item
        }
    }
    return ReturnList
}

fun main() {
    val answer = TwoSum(listOf(0, 8, 5, 2, 1, 12, 4, 3), num = 12)

    // First way of printing elements in nested array
    answer.forEach {
        println(it.contentToString())
    }

    // Second way of printing elements in nested array
    for (item in answer){
        println(item.contentToString())
    }
}