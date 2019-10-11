package algorithms.daily_interview

/*
Given an array nums, write a function to move all 0's to the end of
it while maintaining the relative order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */

fun main(){
    // driver code
    val arr = arrayOf(0, 0, 0, 2, 0, 1, 3, 4, 0, 0)
    val arr2 = arrayOf(0, 1, 2, 3, 0, 5)

    println(moveZeros(arr).contentToString())
    println(moveZeros(arr2).contentToString())
}

fun findZero(arr: Array<Int>, pos: Int): Int{
    // returns position of first zero from pos given
    var newPos = pos
    while (arr[newPos] != 0 && newPos < arr.size){
        newPos += 1
    }
    return newPos
}

fun findNonZero(arr: Array<Int>, pos: Int): Int{
    // returns position of first non-zero from pos given
    var newPos = pos
    while (newPos < arr.size && arr[newPos] == 0){
        newPos += 1
    }
    return newPos
}

fun swapPos(arr: Array<Int>, pos1: Int, pos2: Int): Array<Int>{
    val temp = arr[pos1]
    arr[pos1] = arr[pos2]
    arr[pos2] = temp
    return arr
}

fun moveZeros(arr: Array<Int>): Array<Int>{
    // initialise 2 pointers
    var tempArr = arr
    var pointerA = 0
    var pointerB = 0
    var temp = 0

    while (pointerA < tempArr.size && pointerB < tempArr.size){
        // move pointerA until it hits a 0
        pointerA = findZero(tempArr, pointerA)

        // move pointerB until it is a non-zero
        pointerB = findNonZero(tempArr, pointerA)

        if (pointerA >= tempArr.size || pointerB >=tempArr.size){
            break
        }
        // swap A and B
        tempArr = swapPos(tempArr, pointerA, pointerB)
    }
    return tempArr
}