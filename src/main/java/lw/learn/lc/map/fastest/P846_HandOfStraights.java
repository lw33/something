package lw.learn.lc.map.fastest;


import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-24 21:52:44
 **/
public class P846_HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n<W || n%W!=0){
            return false;
        }
        int[] arr = new int[W];
        for(int i=0;i<n;i++){
            arr[hand[i]%W]++;
        }
        for(int i=0;i<W-1;i++){
            if(arr[i]!=arr[i+1]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] ints = LCUtils.stringToIntegerArray("[1,2,3,6,2,3,4,7,8]");
        System.out.println(this.isNStraightHand(ints, 3));
    }
}
