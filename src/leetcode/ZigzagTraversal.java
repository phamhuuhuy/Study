package leetcode;

import java.util.*;

public class ZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int level = q.size();
            System.out.println(level);
            System.out.println("check-------");
            q.forEach((list) ->{
                System.out.println(list.val);
            });
            System.out.println("check-------");
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                    if (q.peek().right != null) {
                        q.add(q.peek().right);
                    }
                    if (q.peek().left != null) {
                        q.add(q.peek().left);
                    }


                subList.add(q.remove().val);
            }

            if (result.size() % 2 == 1) {
                Collections.reverse(subList);
            }
            result.add(subList);

        }
        return result;
    }
}
