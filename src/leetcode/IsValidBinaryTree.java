package leetcode;

import java.util.Stack;

public class IsValidBinaryTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) break;
                root = stack.pop();
                if(pre != null && root.val <= pre.val) return false;
                pre =root;
                root = root.right;

            }
        }
        return true;
    }
}
