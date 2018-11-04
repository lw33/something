package lw.learn.algorithm

import org.junit.Test

/**
 * @Author lw
 * @Date 2018-10-06 17:30:49
 */
object Test {

    @JvmStatic
    fun main(args: Array<String>) {

        val count = 100000
        var a = true
        var b = false

        val start2 = System.currentTimeMillis()
        for (i in 0 until count) {
            a = i and 1 == 0
        }
        println(a)
        val end2 = System.currentTimeMillis()
        println(end2 - start2)
        val start1 = System.currentTimeMillis()
        for (i in 0 until count) {
            b = i % 2 == 0
        }
        println(b)
        val end1 = System.currentTimeMillis()
        println(end1 - start1)
    }

}
