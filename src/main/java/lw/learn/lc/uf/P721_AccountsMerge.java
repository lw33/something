package lw.learn.lc.uf;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-03-09 21:30:18
 **/
public class P721_AccountsMerge {

    /**
     * 比较挫的实现
     * 使用 map 记录 name -> email
     * email -> name
     * 当存在 email -> name 时，将 name 对应的 email 全部取出，放到当前 name 下
     *
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> res = new ArrayList<>();
        HashMap<String, Set<String>> n2es = new HashMap<>();
        HashMap<String, String> e2n = new HashMap<>();
        for (List<String> account : accounts) {

            String name = account.get(0);
            while (n2es.containsKey(name)) {
                name = name + "#";
            }

            Set<String> emails = new HashSet<>();
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emails.contains(email)) {
                    emails.add(email);
                    if (e2n.containsKey(email)) {
                        String n = e2n.get(email);
                        Set<String> es = n2es.get(n);
                        n2es.remove(n);
                        for (String e : es) {
                            e2n.put(e, name);
                            emails.add(e);
                        }
                    } else {
                        e2n.put(email, name);
                    }
                }
            }
            n2es.put(name, emails);
        }

        n2es.forEach((n, es) -> {
            // 恢复名称
            int i = n.indexOf("#");
            if (i > 0) {
                n = n.substring(0, i);
            }
            // 排序
            List<String> list = new ArrayList<>(es);
            Collections.sort(list);
            list.add(0, n);
            res.add(list);
        });
        return res;
    }

    @Test
    public void test() {
        String s = "[[\"David\",\"David0@m.co\",\"David1@m.co\"],[\"David\",\"David3@m.co\",\"David4@m.co\"],[\"David\",\"David4@m.co\",\"David5@m.co\"],[\"David\",\"David2@m.co\",\"David3@m.co\"],[\"David\",\"David1@m.co\",\"David2@m.co\"]]";
        List<List<String>> st = JSON2Java.jsonTo2List(s);

        System.out.println(this.accountsMerge(st));
    }
}
