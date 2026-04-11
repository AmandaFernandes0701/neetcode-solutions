class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countNums = new HashMap<>();
        
        for(int num : nums) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> listaOrdenada = countNums.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(Collectors.toList());

        int[] arrayResult = new int[k];
        for(int i = 0; i < k; i++) {
            arrayResult[i] = listaOrdenada.get(i).getKey();
        }

        return arrayResult;
    }
}