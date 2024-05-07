package leetcode.anz;

import java.util.*;

public class GraphRelation {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public void register(Integer childNode, Integer parentNode) {
        List<Integer> neighbor = graph.get(parentNode);
        List<Integer> neighborChild = graph.get(childNode);
        if (neighborChild == null) {
            neighborChild = new ArrayList<>();
            neighborChild.add(parentNode);
            graph.put(childNode, neighborChild);
        } else {
            neighborChild.add(parentNode);
        }
        if (neighbor == null) {
            neighbor = new ArrayList<>();
            neighbor.add(childNode);
            graph.put(parentNode, neighbor);
        } else {
            neighbor.add(childNode);
        }
    }
    public void print() {
        graph.forEach((k, v) -> {
            System.out.println("-------------------");
            System.out.println("key: " + k);
            v.forEach(System.out::println);
            System.out.println("-------------------");
        });
    }

    public boolean checkRelation(int nodeA, int nodeB) {

        if (nodeA == nodeB) return true;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(nodeA);
        visited.add(nodeA);

        while(!q.isEmpty()) {
            int curr = q.remove();
            List<Integer> neighbors = graph.get(curr);

            for (Integer neighbor : neighbors) {
                if (nodeB == neighbor) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return false;
    }
}

class MainTest {
    public static void main(String[] args) {
        GraphRelation graphRelation = new GraphRelation();
        graphRelation.register(2,1);
        graphRelation.register(2,3);
        graphRelation.register(3,7);
        graphRelation.register(4,1);
        graphRelation.register(5,2);
        graphRelation.register(5,4);
        graphRelation.register(6,5);
        graphRelation.print();
        System.out.println(graphRelation.checkRelation(3,6));
    }
}
