package Easy;


class Solution {


    public static void main(String[] args) {
        // case 1
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        // case 2
        // int[] nums1 = {1};
        // int m = 1;
        // int[] nums2 = {0};
        // int n = 0;

        // case 3
        // int[] nums1 = {0};
        // int m = 0;
        // int[] nums2 = {1};
        // int n = 1;
        
        merge(nums1, m, nums2, n);
        String result = "{";
        for(int i = 0; i < nums1.length; i++) {
            result += nums1[i] + ",";
        }
        if(result.lastIndexOf(",") > -1)
            result = result.substring(0, result.lastIndexOf(","));
        result += "}";
        System.out.println(result);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int currentIndex = nums1.length - 1;
        int nums1Index = m - 1;
        int nums2Index = n - 1;


        while(nums1Index >= 0 || nums2Index >= 0) {
            if(nums1Index >= 0 && nums2Index >= 0) {
                if (nums1[nums1Index] <= nums2[nums2Index]) {
                    nums1[currentIndex--] = nums2[nums2Index--];
                // } else if (nums1[nums1Index] > nums2[nums2Index]) {
                } else {
                    nums1[currentIndex--] = nums1[nums1Index--];
                }
            } else if(nums2Index < 0) {
                nums1[currentIndex--] = nums1[nums1Index--];
            // } else if (nums2Index == 0) {
            } else {
                nums1[currentIndex--] = nums2[nums2Index--];
            }
        }
    }
}