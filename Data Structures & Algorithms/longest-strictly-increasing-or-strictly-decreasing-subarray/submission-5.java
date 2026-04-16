class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        if(nums.length <= 1) return 1;

        int maxLen = 1;
        int increasingCount = 1;
        int decreasingCount = 1;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[i-1])
            {
                increasingCount++;
                decreasingCount = 1;
            }

            else if(nums[i] < nums[i-1])
            {
                increasingCount = 1;
                decreasingCount++;
            }
            
            else
            {
                increasingCount = 1;
                decreasingCount = 1;
            }

            maxLen = Math.max(maxLen, Math.max(increasingCount, decreasingCount));
        }

        return maxLen;  
    }
}