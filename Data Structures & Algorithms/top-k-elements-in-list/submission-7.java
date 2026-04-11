class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> countFrequency = new HashMap<>();
        
        for(int num : nums)
            countFrequency.put(num, countFrequency.getOrDefault(num, 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry : countFrequency.entrySet())
        {
            int num = entry.getKey();
            int frequencia = entry.getValue();
            
            if(buckets[frequencia] == null)
                buckets[frequencia] = new ArrayList<>();
            
            buckets[frequencia].add(num);
        }

        int[] arrayResult = new int[k];
        int j = 0; 

        for(int i = buckets.length - 1; i >= 0; i--)
        {
            if(buckets[i] != null) { 
                for(int num : buckets[i])
                {
                    arrayResult[j] = num;
                    j++;
                    if(j == k) return arrayResult;      
                }
            }
        }
        
        return arrayResult;
    }
}