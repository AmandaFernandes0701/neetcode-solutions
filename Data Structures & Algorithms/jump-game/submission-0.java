class Solution {
    public boolean canJump(int[] nums) {

        int right = nums.length - 1;
        int left = right - 1;

        while(left >= 0)
        {
            // left consegue chegar no right?
            if(nums[left] >= (right - left))
                right = left;

            left--;
        }

        return right == 0;   
    }
}
