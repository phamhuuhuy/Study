package leetcode;


public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 0;
        while (i<=j && j < nums.length) {

            sum += nums[j];
            System.out.println("i: " + i);
            System.out.println("j: " + j);
            System.out.println("sum: " + sum);
            if (sum == target) {
                if (count == 0 || count > (j - i +1)) {
                    count = j -i +1;
                }
                sum -= nums[i];
                i++;
                j++;
            } else if (sum < target) {
                j++;
            } else {
                if (count == 0 || count > (j - i +1)) {
                    count = j -i +1;
                }
                sum -= nums[i];
                sum -= nums[j];
                i++;
            }
        }
        return count;
    }
}
