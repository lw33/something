package lw.learn.lc.hard;
import org.junit.Test;

import java.util.*;
/**
 * @Author lw
 * @Date 2018-11-24 22:49:59
 **/
public class P218_GetSkyline {

    static class Node {
        public boolean isUp;
        public int pos;
        public int height;

        public Node(boolean isUp, int pos, int height) {
            this.isUp = isUp;
            this.pos = pos;
            this.height = height;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if(buildings.length== 0)
            return res;
        Node[] nodes = new Node[2 * buildings.length];
        for (int i = 0; i < buildings.length; i++) {
            nodes[2 * i] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[2 * i + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(nodes, (a, b) -> {

            if (a.pos != b.pos)
                return a.pos - b.pos;

            else if (a.isUp != b.isUp)
                return a.isUp ? -1 : 1;

            else if (a.height != b.height)
                return a.height - b.height;

            return 0;
        });

        TreeMap<Integer, Integer> hMap = new TreeMap<>();
        TreeMap<Integer, Integer> pMap = new TreeMap<>();

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                if (hMap.containsKey(nodes[i].height)) {
                    hMap.put(nodes[i].height, hMap.get(nodes[i].height) + 1);
                } else {
                    hMap.put(nodes[i].height, 1);
                }
            } else {
                if (hMap.containsKey(nodes[i].height)) {
                    if (hMap.get(nodes[i].height) == 1) {
                        hMap.remove(nodes[i].height);
                    } else {
                        hMap.put(nodes[i].height, hMap.get(nodes[i].height) - 1);
                    }
                }
            }
            if (hMap.isEmpty()) {
                pMap.put(nodes[i].pos, 0);
            } else {
                pMap.put(nodes[i].pos, hMap.lastKey());
            }


        }
        int start = pMap.firstKey();
        int height = pMap.firstEntry().getValue();

        for (Map.Entry<Integer, Integer> entry : pMap.entrySet()) {
            if (height != entry.getValue()) {
                res.add(new int[]{start, height});
                start = entry.getKey();
                height = entry.getValue();
            }
        }
        res.add(new int[]{start, height});
        return res;
    }

    @Test
    public void test() {
        int[][] arr = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        this.getSkyline(arr);
    }
}
