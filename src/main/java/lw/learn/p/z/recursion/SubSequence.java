package lw.learn.p.z.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-22 21:37:34
 **/
public class SubSequence {
    public List<String> subSequence(String str) {

        List<String> seqs = new ArrayList<>();
        subSequence(str.toCharArray(), 0, "", seqs);

        return seqs;
    }

    private void subSequence(char[] str, int index, String seq, List<String> seqs) {
        if (index == str.length) {
            seqs.add(seq);
            return;
        }
        subSequence(str, index + 1, seq, seqs);
        subSequence(str, index + 1, seq + str[index], seqs);
    }

    @Test
    public void test() {
        List<String> strings = subSequence("abc");
        System.out.println(strings);
    }

}
