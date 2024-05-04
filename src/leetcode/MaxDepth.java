package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                if (root.right != null) {
                    q.add(root.right);
                }
                if (root.left != null) {
                    q.add((root.left));
                }
                q.remove();
                System.out.println();
            }
            count++;
        }
        return count;
    }
}
