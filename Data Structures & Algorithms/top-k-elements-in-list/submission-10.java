class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mapFrequency = new HashMap<>();
        int[] resultArray = new int[k];

        for(int num : nums)
            mapFrequency.put(num, mapFrequency.getOrDefault(num, 0) + 1);
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mapFrequency.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int i = 0;

        for(Map.Entry<Integer, Integer> entry : list) 
        {
            if(i == k) break;
            resultArray[i] = entry.getKey();
            i++;
        }

        return resultArray;      
    }
}