package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] candidates, int target, List<Integer> temp, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - sum < candidates[i]) continue;
            temp.add(candidates[i]);
            backtrack(result, candidates, target, temp, sum + candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }
}
