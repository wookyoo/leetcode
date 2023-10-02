class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // solution - O(n)
        Arrays.sort(nums);
        int prevNum = nums[0];
        List<Integer> duplicates = new ArrayList<Integer>();
        for(int i = 1; i < nums.length; i++) {
            if(prevNum == nums[i]) {
                duplicates.add(prevNum);
            }
            prevNum = nums[i];
        }
        return duplicates;
    }
}