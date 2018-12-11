package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-23 12:56:23
 **/
public class P58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String curWord = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                curWord = s.charAt(i) + curWord;
            } else if (curWord.length() != 0) {
                break;
            }
        }
        return curWord.length();
    }

    // 从后往前找
    public int lengthoflastword(String s) {
            if(s==null || s.length()==0)
                return 0;
            int len = s.length();
            int count = 0;
            for(int i=len-1;i>=0;i--){
                if(s.charAt(i)!=' '){
                    count++;
                }else if(s.charAt(i)==' '&& count!=0){
                    return count;
                }
            }
            return count;


    }
    @Test
    public void test() {
        this.lengthOfLastWord("b   a    ");
    }
}
