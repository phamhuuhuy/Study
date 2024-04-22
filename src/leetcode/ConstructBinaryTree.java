package leetcode;


import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTree {
    private  TreeNode treeBuilder(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder.get(0));
        int mid = inorder.indexOf(preorder.get(0));
        treeNode.left = treeBuilder(preorder.subList(1, mid+1), inorder.subList(0, mid));
        treeNode.right = treeBuilder(preorder.subList(mid+1, preorder.size()), inorder.subList(mid+1, inorder.size()));
        return treeNode;
    }

    private  List<Integer> convert(int[] ints) {
        List<Integer> intList = new ArrayList<Integer>(ints.length);
        for (int i : ints)
        {
            intList.add(i);
        }
        return intList;
    }

    private  TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeBuilder(convert(preorder), convert(inorder));
    }

}
