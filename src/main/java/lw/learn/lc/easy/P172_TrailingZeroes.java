package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-29 23:11:07
 **/
public class P172_TrailingZeroes {

    //要求末尾有多少个零，则该数应为x*10k 的形式等于x*（2k *5k）
    //
    //也就是求该数分解质因子后有几个5就行，：如1*2*3*4*5=1*2*3*2*2*5（里面有一个5）所以结果为1个0
    public int trailingZeroes(int n) {

        int sum = 0;

        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
