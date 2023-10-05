class Solution {
    public boolean containsDuplicate(int[] nums) {
        // working but runtime 20ms beats 26.3%, memory 57.54mb beats 15.89%
        /*
        Arrays.sort(nums);
        boolean result = false;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                result = true;
                break;
            }
        }
        return result;
         */

         
        // working but runtime 10ms beats 84.37%, memory 54.35MB beats 98.03% which is better solution
        Set<Integer> map = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.contains(nums[i]))
                return true;
            else
                map.add(nums[i]);
        }
        return false;
    }
}