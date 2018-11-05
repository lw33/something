package lw.learn.lc.easy;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author lw
 * @Date 2018-11-05 16:33:56
 **/
public class UniqueMorseRepresentations_804 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(code[Character.toLowerCase(word.charAt(i)) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
