package leetcode;

import java.util.*;

public class Traversal {

    public List<Integer> bfsLeftToRightTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            result.add(curr.val);
        }
        return result;
    }
    List<Integer> result = new ArrayList<>();

    public List<Integer> dfsLeftToRightTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val); // preorder
        dfs(root.left);
        // inorder
        dfs(root.right);
        // postorder
    }

    public List<Integer> InorderTransverse(TreeNode curr) {

        List <Integer> inOrder = new ArrayList< >();
        Stack<TreeNode> s = new Stack< >();

        while (true) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if (s.isEmpty()) break;
                curr = s.peek();
                inOrder.add(curr.val);
                s.pop();
                curr = curr.right;

            }
        }
        return inOrder;
    }
}
//         5
//     3       7
//   1   4    6  8
//    2
//   9

// stack = [5,3,1]   inorder = []
// stack = [5,3,2] inorder = [1]
// stack = [5,3,2,9] inorder = [1]
// stack = [5,3,2] inorder = [1,9]
// stack = [5,3] inorder = [1,9,2]
// stack = [5,4] inorder = [1,9,2,3]
// stack = [5] inorder = [1,9,2,3,4]
// stack = [7] inorder = [1,9,2,3,4,5]
// stack = [7,6] inorder = [1,9,2,3,4,5]
// stack = [7] inorder = [1,9,2,3,4,5,6]
// stack = [8] inorder = [1,9,2,3,4,5,6,7]
// stack = [] inorder = [1,9,2,3,4,5,6,7,8]