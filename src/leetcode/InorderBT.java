package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderBT {
    public List<Integer> InorderTransverse(TreeNode curr) {

        List <Integer> inOrder = new ArrayList< >();
        Stack <TreeNode> s = new Stack< >();

        while (true) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                System.out.print("Stack: ");
                s.forEach((val) -> {
                    System.out.print(val.val);
                    System.out.print(",");});
                System.out.println();

                if (s.isEmpty()) break;
                curr = s.peek();
                inOrder.add(curr.val);
                s.pop();
                curr = curr.right;


                System.out.print("list: ");
                inOrder.forEach((val) -> {
                    System.out.print(val);
                    System.out.print(",");});
                System.out.println();
            }
        }
        return inOrder;
    }
}
