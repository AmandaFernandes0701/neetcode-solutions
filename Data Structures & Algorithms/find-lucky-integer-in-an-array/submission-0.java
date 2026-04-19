class Solution {
    public int findLucky(int[] arr) {

        HashMap<Integer, Integer> mapFrequency = new HashMap<>();
        int maxLuckyNum = -1;

        for(int num : arr)
            mapFrequency.put(num, mapFrequency.getOrDefault(num, 0) + 1);
        
        for(Map.Entry<Integer, Integer> entry: mapFrequency.entrySet())
        {
            if(entry.getKey() == entry.getValue())
                maxLuckyNum = Math.max(maxLuckyNum, entry.getKey());
        }

        return maxLuckyNum;     
    }
}