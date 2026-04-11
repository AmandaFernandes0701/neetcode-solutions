class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hashSetNums = new HashSet<>();
        int maxLen = 0;

        for(int num : nums)
            hashSetNums.add(num);
        
        for(int num : hashSetNums)
        {
            int currNum = num;
            int currLen = 1;

            while(hashSetNums.contains(currNum - 1))
                currNum--;
            
            while(hashSetNums.contains(currNum + 1))
            {
                currLen++;
                currNum++;
            }

            maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen;
    }
}
