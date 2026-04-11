class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hashSetNums = new HashSet<>();
        HashSet<Integer> seenNums = new HashSet<>();

        int maxLen = 0;

        for(int num : nums)
            hashSetNums.add(num);
        
        for(int num : hashSetNums)
        {
            int currNum = num;
            int currLen = 1;

            while(hashSetNums.contains(currNum - 1) && !seenNums.contains(currNum - 1))
                currNum--;
            
            while(hashSetNums.contains(currNum + 1))
            {
                seenNums.add(currNum);
                currLen++;
                currNum++;
            }

            maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen;
    }
}
