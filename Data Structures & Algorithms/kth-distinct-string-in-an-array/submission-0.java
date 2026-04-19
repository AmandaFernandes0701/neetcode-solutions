class Solution {
    public String kthDistinct(String[] arr, int k) {

/*
d : 1
b : 2
c : 2
a : 1


*/
        LinkedHashMap<String, Integer> mapFrequencyCount = new LinkedHashMap<>();

        for(String str : arr)
            mapFrequencyCount.put(str, mapFrequencyCount.getOrDefault(str, 0) + 1);
        
        for(Map.Entry<String, Integer> entry: mapFrequencyCount.entrySet())
        {
            if(entry.getValue() == 1) k--;
            if(k == 0) return entry.getKey();
        }

        return "";     
    }
}