class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        Arrays.sort(nums);
        for(int num : nums)
            System.out.print(num + " ");

        int longestLength = 1;
        int currLongestLength = 1;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == nums[i - 1] + 1) currLongestLength++;
            else
            {
                longestLength = Math.max(longestLength, currLongestLength);
                currLongestLength = 1;
            }
        }

        longestLength = Math.max(longestLength, currLongestLength);

        return longestLength;     
    }
}
