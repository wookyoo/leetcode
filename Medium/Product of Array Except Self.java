class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for(int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        // i=0, 1
        // i=1, 1*1 = 1
        // i=2, 1*2 = 2
        // i=3, 2*3 = 6

        int suffix = 1;
        for(int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        // i=3, 6*1 = 6, 1*4 = 4
        // i=2, 2*4 = 8, 4*3 = 12
        // i=1, 1*12 = 12, 12*2 = 24
        // i=0, 1*24 = 24, 24*1 = 24


        // example 2
        // prefix
        // i=0, 1
        // i=1, 1*-1 = -1
        // i=2, -1*1 = -1
        // i=3, -1*0 = 0
        // i=4, 0*-3 = 0
        // suffix
        // i=4, 0*1 = 0, 1*3 = 3
        // i=3, 0*3 = 0, 3*-3 = -9
        // i=2, -1*-9 = 9, -9*0 = 0
        // i=1, -1*0 = 0, 0*1 = 0
        // i=0, 1*0 = 0, 0*-1 = 0
        return answer;
    }
}

/*
Runtime
    Details
    2ms
    Beats 66.08%of users with Java
Memory
    Details
    52.89MB
    Beats 47.92%of users with Java
 */