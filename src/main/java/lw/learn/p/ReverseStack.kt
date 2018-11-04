package lw.learn.p

import org.junit.Test

import java.util.Stack

/**
 * @Author lw
 * @Date 2018-10-07 12:17:00
 */
class ReverseStack {


    operator fun get(stack: Stack<Int>): Int {
        val result = stack.pop()
        if (stack.isEmpty()) {
            return result
        } else {
            val last = get(stack)
            stack.push(result)
            return last
        }
    }

    fun reverse(stack: Stack<Int>) {
        if (stack.isEmpty()) {
            return
        } else {
            val i = get(stack)
            reverse(stack)
            stack.push(i)
        }
    }


    @Test
    fun test() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        println(stack)
        reverse(stack)
        println(stack)
    }
}
