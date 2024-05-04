package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (tempList.contains(nums[i])) continue;

            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() -1);
        }

    }
}


