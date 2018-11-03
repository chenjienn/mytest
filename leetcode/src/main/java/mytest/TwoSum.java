package mytest;

/**
 * @Author: JieChen
 * @Date: 2018/11/2
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        int[] result = new TwoSum().twoSum(nums, target);
        System.out.println(result);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 1; i < nums.length + 1; i++) {
            int sum = 0;
            int[] result = new int[i];
            if (combination(nums, result, 0, i, sum, target, 0)) {
                return result;
            }
        }
        return new int[0];
    }


    public boolean combination(int[] nums, int[] result, int startIndex, int selectNum, int sum, int target, int depth) {
        if (selectNum == 0) {
            return false;
        }
        int temp = sum;
        for (int i = startIndex; i < (nums.length - selectNum + 1); i++) {
            sum = temp;
            if (nums[i] > target) {
                return false;
            }
            sum += nums[i];
            result[depth] = i;
            if (sum == target) {
                return true;
            }
            if (sum > target) {
                return false;
            }
            if (combination(nums, result, i + 1, selectNum - 1, sum, target, depth + 1)) {
                return true;
            }
        }
        return false;
    }
}
