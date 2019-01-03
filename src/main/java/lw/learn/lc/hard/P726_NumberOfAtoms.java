package lw.learn.lc.hard;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author lw
 * @Date 2019-01-03 00:09:53
 **/
public class P726_NumberOfAtoms {

    public String countOfAtoms(String formula) {
        if (formula.length() == 0) {
            return "";
        }
        Map<String, Integer> hash = countOfAtoms(formula.toCharArray(), 0);
        StringBuilder sb = new StringBuilder();

        hash.forEach((k, v) -> {
            if (!"z".equals(k)) {
                sb.append(k);
                if (v > 1) {
                    sb.append(v);
                }
            }
        });
        return sb.toString();
    }

    public Map<String, Integer> countOfAtoms(char[] formula, int index) {
        Map<String, Integer> map = new TreeMap<>();
        int pre = 0;
        StringBuilder sb = new StringBuilder();
        while (index < formula.length && formula[index] != ')') {
            if (isUpperLetter(formula[index])) {
                if (++index < formula.length && (isNum(formula[index]) || isLowerLetter(formula[index]))) {
                    sb.append(formula[index - 1]);
                    continue;
                }
                pre = 0;
                map.put(String.valueOf(formula[index - 1]), map.getOrDefault(String.valueOf(formula[index - 1]), 0) + 1);
            } else if (isNum(formula[index])) {
                pre = pre * 10 + formula[index++] - '0';
                if (index < formula.length && isNum(formula[index])) {
                    continue;
                }

                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + pre);
                pre = 0;
                sb.delete(0, sb.length());
            } else if (isLowerLetter(formula[index])) {
                sb.append(formula[index++]);
                if (index < formula.length && isLowerLetter(formula[index])) {
                    continue;
                }
                if (index < formula.length && (isUpperLetter(formula[index]) || formula[index] == '(' || formula[index] == ')')) {
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    sb.delete(0, sb.length());
                }
            } else {
                TreeMap<String, Integer> retHash = (TreeMap<String, Integer>) countOfAtoms(formula, index + 1);
                index = retHash.lastEntry().getValue();
                retHash.forEach((k, v) -> {
                    if (!"z".equals(k)) {
                        map.put(k, map.getOrDefault(k, 0) + v);
                    }
                });
            }
        }
        pre = 0;
        if (index < formula.length && formula[index] == ')') {
            while (++index < formula.length && isNum(formula[index])) {
                pre = pre * 10 + formula[index] - '0';
            }
            int finalPre = pre;
            map.forEach((k, v) -> map.put(k, v * finalPre));
        }
        map.put("z", index);
        return map;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isUpperLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isLowerLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    @Test
    public void test() {
        String s1 = "H2O";
        String s2 = "Mg(OH)2";
        String s3 = "((HHe28Be26He)9)34";
        System.out.println(this.countOfAtoms(s1));
        System.out.println(this.countOfAtoms(s2));
        System.out.println(this.countOfAtoms(s3));
    }
}
