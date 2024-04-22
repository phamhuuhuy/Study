package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    public Node dfs(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) return map.get(node.val);
        Node copy = new Node(node.val);
        for (Node neighbor: node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();

        return dfs(node, map);
    }
}
