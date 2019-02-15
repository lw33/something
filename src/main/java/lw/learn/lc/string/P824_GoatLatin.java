package lw.learn.lc.string;

/**
 * @Author lw
 * @Date 2019-02-15 10:23:56
 **/
public class P824_GoatLatin {

    public static final boolean[] vowel = new boolean[127];

    static {
        //a, e, i, o, u
        vowel['a'] = true;
        vowel['A'] = true;

        vowel['e'] = true;
        vowel['E'] = true;

        vowel['i'] = true;
        vowel['I'] = true;

        vowel['o'] = true;
        vowel['O'] = true;

        vowel['u'] = true;
        vowel['U'] = true;
    }

    public static final String MA = "ma";

    public String toGoatLatin(String S) {
        if (S.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        String[] s = S.split(" ");
        int aCount = 1;
        for (String s1 : s) {
            if (vowel[s1.charAt(0)]) {
                res.append(s1);
            } else {
                res.append(s1.substring(1));
                res.append(s1.charAt(0));
            }
            res.append(MA);
            for (int i = 0; i < aCount; i++) {
                res.append('a');
            }
            res.append(" ");
            aCount++;
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
