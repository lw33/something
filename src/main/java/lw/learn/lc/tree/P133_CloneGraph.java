package lw.learn.lc.tree;

import lw.learn.lc.ds.UndirectedGraphNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-02-08 20:54:46
 **/
public class P133_CloneGraph {


    /**
     * 将每次遍历到的未访问的节点 存入map
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        dfs(node, map);
        return map.get(node.label);
    }

    private void dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode undirectedGraphNode = map.get(node.label);
        // map 中已经存在这个节点 则证明遍历过这个节点
        if (undirectedGraphNode != null) {
            return;
        }
        // 第一次遍历到 创建
        undirectedGraphNode = new UndirectedGraphNode(node.label);
        // 加入 map
        map.put(node.label, undirectedGraphNode);
        // 遍历 neighbors
        for (UndirectedGraphNode neighbor : node.neighbors) {
            // 如果是当前节点 直接加入新建的 node
            if (neighbor.label == node.label) {
                undirectedGraphNode.neighbors.add(undirectedGraphNode);
                continue;
            }
            // 递归遍历
            dfs(neighbor, map);
            // 递归结束后 其 neighbor 将被完全创建 加入 到 neighbors
            undirectedGraphNode.neighbors.add(map.get(neighbor.label));
        }
    }

    @Test
    public void test() {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);
        UndirectedGraphNode undirectedGraphNode = this.cloneGraph(node0);
        UndirectedGraphNode.printGraph(undirectedGraphNode);
        System.out.println();
    }
}
