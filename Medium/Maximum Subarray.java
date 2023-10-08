class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}

/*
Runtime
    Details
    1ms
    Beats 100.00% of users with Java
Memory
    Details
    59.50MB
    Beats 49.96% of users with Java
 */