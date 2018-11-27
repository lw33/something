package lw.learn.lc.fastest.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-11-27 23:15:59
 **/
// TODO: 2018/11/27  欧几里何
public class HasGroupsSizeX_914 {
    class Solution {

        public int GCD(int a, int b) {
            if(b==0)
                return a;
            return a % b == 0 ? b : GCD(b, a % b);
        }
        public boolean hasGroupsSizeX(int[] deck) {
            int arr[]=new int[10005];
            for(int i=0;i<deck.length;i++){
                arr[deck[i]]++;
            }
            boolean flag=true;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=0){
                    min=Math.min(arr[i],min);
                }
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=0){
                    if(arr[i]<2)
                        return false;
                    if(GCD(min,arr[i])<2){
                        flag=false;
                        break;
                    }
                }
            }
            return flag;
        }
    }

}
