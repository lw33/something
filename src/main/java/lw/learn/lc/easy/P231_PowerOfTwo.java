package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-22 23:41:13
 **/
public class P231_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
       /* if(n<=0) return false;
        return (n&n-1)==0;*/
        return (n>0)&&((n&(n-1))==0);
    }
}
