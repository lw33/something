package lw.learn.lc.string;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-01-18 23:42:27
 **/
public class P929_UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            char[] chars = email.toCharArray();
            int i = 0;
            for (; i < chars.length; i++) {
                if (chars[i] != '.') {
                    if (chars[i] == '+') {
                        break;
                    } else if (chars[i] == '@') {
                        break;
                    } else {
                        sb.append(chars[i]);
                    }
                }
            }
            while (chars[i] != '@') {
                i++;
            }
            sb.append(email.substring(i + 1));
            set.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return set.size();
    }
}
