package lw.learn.lc.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-12 12:36:47
 **/
public class P811_SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            int freq = Integer.parseInt(s[0]);
            String[] split = s[1].split("\\.");
            String end = split[split.length - 1];
            sb.append(end);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + freq);
            for (int i = split.length - 2; i >= 0; i--) {
                sb.insert(0, ".");
                sb.insert(0, split[i]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + freq);
            }
            sb.delete(0, sb.length());
        }
        List<String> res = new LinkedList<>();
        map.forEach((k, v) -> res.add(v + " " + k));
        return res;
    }

    @Test
    public void test() {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 org"};
        System.out.println(this.subdomainVisits(s));
    }
}
