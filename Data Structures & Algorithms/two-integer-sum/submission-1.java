class Solution {
    public int[] twoSum(int[] nums, int target) {
    
        HashMap<Integer, Integer> mapIndices = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int numProcurado = target - nums[i];

            if(mapIndices.containsKey(numProcurado))
                return new int[] {mapIndices.get(numProcurado), i};
            
            else mapIndices.put(nums[i], i);
        }

        return new int[] {-1, -1};
        
    }
}
