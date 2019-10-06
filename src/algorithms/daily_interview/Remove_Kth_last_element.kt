package algorithms.daily_interview

import java.util.*

// Problem:
/*
    You are given a singly linked list and an integer k. Return the linked list,
    removing the k-th last element from the list.

    Try to do it in a single pass and using constant space.
 */

fun main() {
    // driver
    println("Original:")
    val head = Node(1,
                    Node(2,
                        Node(3 ,
                            Node(4,
                                Node(5, null)
                            )
                        )
                    )
                )
    head.printArr()

    println("\nEditted:")

    // test case
    val newHead = remove_kth_from_linked_list(head, 3)
    newHead.printArr()
}



class Node (var value: Int, var next: Node?) {
    fun printArr(){
        var n = this@Node
        val display = ArrayList<Int>()

        while (n.next!=null){
            display.add(n.value)
            n = n.next!!
        }
        display.add(n.value)
        println(display.toString())
    }
}


fun remove_kth_from_linked_list(head: Node, k: Int) : Node{
    // catch case where length of linked list is smaller than k
    var current = head
    for (i in 0 until k){  // range from [0,k)
        if (current.next == null){
            return head
        }
        current = current.next!!
    }

    var pointer2 = head
    while (current.next!=null){  // move current to end
        current = current.next!!
        pointer2 = pointer2.next!!
    }

    // pointer2.next is now the node to be removed
    pointer2.next = pointer2.next!!.next!!

    return head
}
