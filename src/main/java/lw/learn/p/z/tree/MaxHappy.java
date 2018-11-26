package lw.learn.p.z.tree;

import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-26 13:47:07
 **/
public class MaxHappy {

    class Node {
        public int active;
        public List<Node> subordinates;

        public Node(int active, List<Node> subordinates) {
            this.active = active;
            this.subordinates = subordinates;
        }
    }

    class ReturnData {

        int ca;  // 来的活跃度
        int nca; // 不来的活跃度

        public ReturnData(int ca, int nca) {
            this.ca = ca;
            this.nca = nca;
        }
    }

    public int maxHappy(Node root) {
        ReturnData maxHappy = getMaxHappy(root);
        return Math.max(maxHappy.nca, maxHappy.ca);
    }

    private ReturnData getMaxHappy(Node head) {
        int ca = head.active;
        int nca = 0;
        for (Node subordinate : head.subordinates) {
            ReturnData maxHappy = getMaxHappy(subordinate);
            ca += maxHappy.nca;
            nca += Math.max(maxHappy.nca, ca);
        }
        return new ReturnData(ca, nca);
    }
    

}
