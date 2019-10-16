package algorithms.daily_interview

/*
You are given a 2D array of integers. Print out the clockwise spiral traversal of the matrix.

Example:

grid = [[1,  2,  3,  4,  5],
        [6,  7,  8,  9,  10],
        [11, 12, 13, 14, 15],
        [16, 17, 18, 19, 20]]

The clockwise spiral traversal of this array is:

1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12
 */

fun main(){
    // driver code
    val grid = arrayOf(
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(6, 7, 8, 9, 10),
            arrayOf(11, 12, 13, 14, 15),
            arrayOf(16, 17, 18, 19, 20)
        )

    // traverse, currently O(nm) time, space is O(m^2 n^2), where n is the length of arr[0], m is length of arr
    val s = SlicingClockwise()
    println(s.traverseClockWise(grid).contentToString())

    // optimization, possible to do with space O(mn) using another 2d array "seen" with bool
    // Also possible to optimize above method by slicing more efficiently and mutating original 2d array (?)
    // Not sure if possible to reduce time complexity
}


class SlicingClockwise(){

    fun traverseClockWise(arr2d: Array<Array<Int>>): Array<Int>{
        return traverseRight(arr2d, arrayOf())
    }

    fun traverseRight(arr2d: Array<Array<Int>>, current: Array<Int>): Array<Int>{
        // catch base case
        if (arr2d.isEmpty()){
            return current
        }

        val newArray = current + arr2d[0]
        return traverseDown(arr2d.copyOfRange(1, arr2d.size), newArray)
    }

    fun traverseDown(arr2d: Array<Array<Int>>, current: Array<Int>): Array<Int>{
        // catch base case
        if (arr2d.isEmpty()){
            return current
        }

        var newArray = current
        for (element in arr2d){
            newArray += element[arr2d[0].size - 1]
        }

        val tempSize = arr2d[0].size - 1

        for (i in arr2d.indices){
            arr2d[i] = arr2d[i].copyOfRange(0, tempSize)
        }

        return traverseLeft(arr2d, newArray)
    }

    fun traverseLeft(arr2d: Array<Array<Int>>, current: Array<Int>): Array<Int>{
        // catch base case
        if (arr2d.isEmpty()){
            return current
        }

        var newArray = current

        for (i in arr2d[0].size - 1 downTo 0){
            newArray += arr2d[arr2d.size - 1][i]
        }

        return traverseUp(arr2d.copyOfRange(0, arr2d.size - 1), newArray)
    }

    fun traverseUp(arr2d: Array<Array<Int>>, current: Array<Int>): Array<Int>{
        // catch base case
        if (arr2d.isEmpty()){
            return current
        }

        var newArray = current
        for (i in arr2d.size - 1 downTo 0){
            newArray += arr2d[i][0]
        }

        val tempSize = arr2d[0].size

        for (i in arr2d.indices){
            arr2d[i] = arr2d[i].copyOfRange(1, tempSize)
        }

        return traverseRight(arr2d, newArray)
    }
}


