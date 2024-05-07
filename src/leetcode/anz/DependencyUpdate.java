package leetcode.anz;

import java.util.*;

public class DependencyUpdate {
    HashMap<String, List<String>> graph = new HashMap<>();

    public void createGraphFromList(List<String> dependencies) {
        for (String dependency: dependencies) {
            String[] strings= dependency.split(":");
            String parent = strings[0];
            String child = strings[1];
            List<String> dependenciesOfNode = graph.get(child);
            if (dependenciesOfNode == null) {
                dependenciesOfNode = new ArrayList<>();
                dependenciesOfNode.add(parent);
                graph.put(child, dependenciesOfNode);
            } else {
                dependenciesOfNode.add(parent);
            }
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

    public Set<String> relatedUpdate(List<String> listUpdate) {
        Set<String> result = new HashSet<>();
        for (String update: listUpdate) {
            dfs(update, result);
        }
        return result;
    }

    public void dfs(String update, Set<String> result) {
        result.add(update);
        List<String> dependencies = graph.get(update);
        if (dependencies == null) {
            return;
        }
        for (String dependency : dependencies) {
            result.add(dependency);
            dfs(dependency, result);
        }
    }

}

class MainTest1 {
    public static void main(String[] args) {
        DependencyUpdate graphRelation = new DependencyUpdate();
        List<String> dependencies = new ArrayList<>();
        dependencies.add("a:b");
        dependencies.add("b:c");
        dependencies.add("h:c");
        dependencies.add("d:f");
        graphRelation.createGraphFromList(dependencies);
        graphRelation.print();
        graphRelation.relatedUpdate(List.of("b","c")).forEach(v -> System.out.println("ket qua: " + v));
    }
}
