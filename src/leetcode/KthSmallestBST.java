package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestBST {
    public int kthSmallestBST(TreeNode curr, int k) {

            List <Integer> inOrder = new ArrayList< >();
            Stack<TreeNode> s = new Stack< >();

            while (true) {
                if (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                } else {
                    k--;
                    if (s.isEmpty()) break;
                    curr = s.peek();
                    if (k == 0) return curr.val;
                    inOrder.add(curr.val);
                    s.pop();
                    curr = curr.right;

                }
            }
            return -1;
    }
}
