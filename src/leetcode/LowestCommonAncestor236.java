package leetcode;

public class LowestCommonAncestor236 {
    // the line below is the most hard to understand
    // for the first level recursion, if p(or q) is exactly the whole tree's root, return the root(because root is the lowest node).
    // for deeper(higher nodes) recursions, it indicates:
    // (1) we find p(or q), which is fine because this node will not be returned(to output) instantly since it belongs to a deeper recursion but will be used for determinations of shallower(lower nodes) recursions
    // (2) we reach the bottom of the tree, terminate the current track instantly and "null" will also be used for shallower recursions' determine statements.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        System.out.println();

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
