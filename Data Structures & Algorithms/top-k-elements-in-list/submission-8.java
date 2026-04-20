class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mapFrequency = new HashMap<>();
        int[] resultArray = new int[k];
        List<Integer>[] bucketNums = new ArrayList[nums.length + 1];

        for(int num : nums)
            mapFrequency.put(num, mapFrequency.getOrDefault(num, 0) + 1);
        
        for(Map.Entry<Integer, Integer> entry: mapFrequency.entrySet())
        {
            int val = entry.getValue();
            int key = entry.getKey();

            if(bucketNums[val] == null)
                bucketNums[val] = new ArrayList<>(List.of(key));
            else
                bucketNums[val].add(key);
        }
        
        int idx = 0;

        for(int i = bucketNums.length - 1; i >= 0; i--)
        {
            if(bucketNums[i] != null)
            {
                for(int num : bucketNums[i])
                {
                    if(idx == k) return resultArray;
                    resultArray[idx] = num;
                    idx++;
                }
            }
        }
        

        return resultArray;      
    }
}
