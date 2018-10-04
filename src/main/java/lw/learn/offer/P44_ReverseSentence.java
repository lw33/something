package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-03 13:10:45
 *
 * 题目描述
 *  新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 **/
public class P44_ReverseSentence {

    public String ReverseSentence(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        String[] s = str.split(" ");
        if (s.length < 1) {
            return str;
        }
        reverse(s);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length - 1; i++) {
            sb.append(s[i] + " ");
        }
        sb.append(s[s.length - 1]);
        return sb.toString();
    }

    public void reverse(String[] strs) {
        int start = 0;
        int end = strs.length - 1;
        while (end > start) {
            String tmp = strs[start];
            strs[start] = strs[end];
            strs[end] = tmp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        System.out.println(this.ReverseSentence("I am a student."));
    }
}
