package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Pick a starting point.
//  while(Problem is not solved)
//     For each path from the starting point.
//        check if selected path is safe, if yes select it
//        and make recursive call to rest of the problem
//        before which undo the current move.
//     End For
//If none of the move works out, return false, NO SOLUTON.
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}