package lw.learn.lc.easy;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2018-12-06 19:27:39
 **/
public class ReverseVowels_345 {

    private static HashSet<Character> vowels = new HashSet<>();
    static {
        //a[ei]、e[i:]、i[ ai]、o[eu]、u[ju:]
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
    }
    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (end > start) {

            if (!vowels.contains(chars[start])) {
                start++;
                continue;
            }
            if (!vowels.contains(chars[end])) {
                end--;
                continue;
            }
            swap(chars, start, end);
            start++;
            end--;
        }
        return new String(chars);
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
    
    @Test
    public void test() {
        String hello = "Aa";
        System.out.println(this.reverseVowels(hello));
    }
}
