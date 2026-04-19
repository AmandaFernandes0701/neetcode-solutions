class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxVal = 0;
        int currVal = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1) currVal++;
            else currVal = 0;
            maxVal = Math.max(maxVal, currVal);
        }
        
        return maxVal;
    }
}