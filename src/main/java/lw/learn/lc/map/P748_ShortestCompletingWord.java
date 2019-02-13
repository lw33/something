package lw.learn.lc.map;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-11 22:23:25
 **/
public class P748_ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {

        int minLen = Integer.MAX_VALUE;
        int[] map = new int[26];
        int sum = 0;
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                map[c - 'a']++;
                sum++;
            } else if (c >= 'A' && c <= 'Z') {
                map[c - 'A']++;
                sum++;
            }
        }
        String res = "";
        for (String word : words) {
            if (match(map, word.toCharArray(), sum)) {
                if (minLen > word.length()) {
                    res = word;
                    minLen = word.length();
                }
            }
        }
        return res;
    }

    public boolean match(int[] map, char[] words, int sum) {
        int[] wordMap = Arrays.copyOf(map, map.length);

        for (char word : words) {
            if (word >= 'a' && word <= 'z') {
                if (wordMap[word - 'a'] > 0) {
                    wordMap[word - 'a']--;
                    sum--;
                }
            } else if (word >= 'A' && word <= 'Z') {
                if (wordMap[word - 'A'] > 0) {
                    wordMap[word - 'A']--;
                    sum--;

                }
            }
            if (sum == 0) {
                return true;
            }
        }
        return false;
    }
}
