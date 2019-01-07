package lw.learn.lc.string;

/**
 * @Author lw
 * @Date 2019-01-07 22:48:03
 **/
// FIXME 2019/1/7  
public class P12_IntegerToRoman {

    public String intToRoman(int num) {
        StringBuffer ans = new StringBuffer();
        int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i = 0; i < vals.length; i++) {
            while(num >= vals[i]) {
                ans.append(romans[i]);
                num -= vals[i];
            }
        }
        return ans.toString();
    }
}
