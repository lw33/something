package lw.learn.lc.bit;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-04 19:25:58
 **/
public class P756_PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, HashSet<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String str = s.substring(0, 2);
            HashSet<Character> set = map.getOrDefault(str, new HashSet<>());
            set.add(s.charAt(2));
            map.put(str, set);
        }
        LinkedList<Character> list = new LinkedList<>();
        for (char c : bottom.toCharArray()) {
            list.add(c);
        }
        return pyramidTransition(list, new LinkedList<>(), map);
    }

    private boolean pyramidTransition(LinkedList<Character> bottom, LinkedList<Character> help, HashMap<String, HashSet<Character>> allowed) {
        if (bottom.isEmpty()) {
            LinkedList<Character> tmp = bottom;
            bottom = help;
            help = tmp;
        }
        if (help.isEmpty() && bottom.size() == 2) {
            return allowed.containsKey(bottom.pollFirst() + "" + bottom.pollFirst());
        }
        Character l = bottom.pollFirst();
        while (!bottom.isEmpty()) {
            Character r = bottom.peekFirst();
            if (bottom.size() == 1) {
                bottom.pollFirst();
            }
            if (allowed.containsKey(l + "" + r)) {
                HashSet<Character> characters = allowed.get(l + "" + r);
                for (Character character : characters) {
                    help.add(character);
                    if (pyramidTransition(new LinkedList<>(bottom), new LinkedList<>(help), allowed)) {
                        return true;
                    }
                }
            }
            l = r;
        }
        return false;
    }

    @Test
    public void test() {
        //List<String> allowed = JSON.parseArray("[\"CDD\",\"ABB\",\"CDC\",\"CDA\",\"AAB\",\"BAD\",\"ACD\",\"BBB\",\"BDB\",\"BCC\",\"DAC\",\"ADD\",\"ADC\",\"ADA\",\"ACA\",\"CCB\",\"BCB\",\"CAD\"]", String.class);
        //String bottom = "BCD";
        List<String> allowed = JSON.parseArray("[\"AAA\",\"AAB\",\"ABA\",\"ABB\",\"BAC\"]", String.class);
        String bottom = "AABA";
        System.out.println(this.pyramidTransition(bottom, allowed));
    }
}
