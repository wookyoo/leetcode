class Solution {
    public int maxProduct(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int maxProduct = nums[0];

        for(int i = 0; i < nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }

        return maxProduct;
    }
}

/*
Runtime
    Details
    1ms
    Beats 86.82%of users with Java
Memory
    Details
    42.98MB
    Beats 85.53%of users with Java
 */