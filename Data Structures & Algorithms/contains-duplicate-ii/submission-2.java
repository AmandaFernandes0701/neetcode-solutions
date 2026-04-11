class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int left = 0;
        HashSet<Integer> currWindow = new HashSet<>();

        for(int right = 0; right < nums.length; right++)
        {
            if(right - left > k)
            {
                currWindow.remove(nums[left]);
                left++;
            }
            
            if(currWindow.contains(nums[right])) return true;

            currWindow.add(nums[right]);
        }

        return false;
    }
}