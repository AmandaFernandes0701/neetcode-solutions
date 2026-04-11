class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, List<Integer>> mapIndices = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];

            if(mapIndices.containsKey(num))
                mapIndices.get(num).add(i);

            else
            {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);      
                mapIndices.put(num, newList);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : mapIndices.entrySet())
        {
            if(entry.getValue().size() == 1) continue;

            List<Integer> listIndices = entry.getValue();

            for(int i = 1; i < listIndices.size(); i++)
                if(Math.abs(listIndices.get(i-1) - listIndices.get(i)) <= k) return true;
        }
            
        return false;
    }
}


