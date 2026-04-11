class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Integer> mapIndices = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];

            if(mapIndices.containsKey(num) && Math.abs(mapIndices.get(num) - i) <= k)
                return true;
            
            mapIndices.put(num, i);
        }

        return false;
    }
}