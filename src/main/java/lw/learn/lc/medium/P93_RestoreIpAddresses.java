package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-07 23:09:23
 **/
public class P93_RestoreIpAddresses {

    //25525511135
    //["255.255.11.135", "255.255.111.35"]
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4) {
            return res;
        }
        ip(s, "", 0, 0, res);
        return res;
    }

    public void ip(String s, String ipStr, int index, int length, List<String> res) {
        if (length > 4) {
            return;
        }
        if (index == s.length()) {
            if (length != 4 || ipStr.length() != s.length()+ 4) {
                return;
            }
            res.add(ipStr.substring(0, ipStr.length() - 1));
        }
        int ip = 0;
        int next = index;
        for (int i = 1; next < s.length() && i < 4; i++) {
            ip = ip * 10 + s.charAt(next) - '0';
            next = index + i;
            if (ip < 256) {
                ip(s, ipStr + ip + ".", next, length + 1, res);
            } else {
                break;
            } 
        }
    }
    
    @Test
    public void test() {
        String ip = "010010";
        System.out.println(this.restoreIpAddresses(ip));
    }
}
