class Solution {
    public int longestMonotonicSubarray(int[] nums) {

/*

nums = [24,   47,   24,   23,   14,   6,    9,    2,    3,    19]
                     i


increasing = true
currLen = 1
maxLen = 2



*/

        if(nums.length == 1) return 1;

        boolean increasing = (nums[0] <= nums[1])? true : false;
        int maxLen = 1;
        int currLen = 1;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == nums[i-1])
            {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
                continue;
            }
            // se estava crescendo antes e continua crescendo agora
            else if(increasing && nums[i] > nums[i-1]) currLen++;

            //se estava diminuindo antes e continua diminuindo agora
            else if(!increasing && nums[i] < nums[i-1]) currLen++;

            // se estava crecsendo antes e começou a diminuir
            else if(increasing && nums[i] < nums[i-1])
            {
                maxLen = Math.max(maxLen, currLen);
                currLen = 2;
                increasing = false;
            }
            // se estava diminuindo antes e começou a aumentar
            else if(!increasing && nums[i] > nums[i-1])
            {
                maxLen = Math.max(maxLen, currLen);
                currLen = 2;
                increasing = true;
            }
        }

        maxLen = Math.max(maxLen, currLen);

        return maxLen;
        
    }
}