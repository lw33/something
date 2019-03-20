package lw.learn.lc.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-03-19 23:25:22
 **/
public class P895_MaximumFrequencyStack {

    class FreqStack {

        private Map<Integer, Integer> freq = new HashMap<>();
        private Map<Integer, LinkedList<Integer>> freq2stack = new HashMap<>();
        private int maxFreq;

        public FreqStack() {

        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            if (f > maxFreq) {
                maxFreq = f;
            }
            LinkedList<Integer> stack = freq2stack.getOrDefault(f, new LinkedList<>());
            stack.push(x);
            freq.put(x, f);
            freq2stack.putIfAbsent(f, stack);
        }

        public int pop() {
            LinkedList<Integer> stack = freq2stack.get(maxFreq);
            if (stack.size() == 1) {
                freq2stack.remove(maxFreq);
                maxFreq--;
            }
            int res = stack.pop();
            int f = freq.get(res);
            if (f == 1) {
                freq.remove(res);
            } else {
                freq.put(res, f - 1);
            }
            return res;
        }
    }
}
