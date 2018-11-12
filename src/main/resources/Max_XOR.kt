/**
 * @Author lw
 * @Date 2018-10-19 17:08:12
 */
object Max_XOR {

    private var a = 1;
    fun getMaxXor1(arr: IntArray): Int {

        var max = Integer.MIN_VALUE

        for (i in arr.indices) {
            for (j in 0..i) {
                var res = 0
                for (k in j..i) {
                    res = res xor arr[k]
                }
                max = Math.max(res, max)
            }
        }
        return max
    }

    fun getMaxXor21(arr: IntArray): Int {
        var max = Integer.MIN_VALUE
        val dp = IntArray(arr.size)
        var xor = 0
        for (i in arr.indices) {
            xor = xor xor arr[i]
            max = Math.max(xor, max)
            for (j in 1..i) {
                val x = xor xor arr[j - 1]
                max = Math.max(x, max)
            }

            dp[i] = xor
        }
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {

    }

}
