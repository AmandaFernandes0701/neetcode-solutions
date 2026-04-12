class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));

        for(int i = 1; i < rowIndex + 1; i++)
        {
            List<Integer> currList = new ArrayList<>();
            currList.add(1);

            for(int j = 0; j < result.get(i-1).size() - 1; j++)
            {
                int sum = result.get(i-1).get(j) + result.get(i-1).get(j+1);
                currList.add(sum);
            }

            currList.add(1);
            result.add(currList);
        }

        return result.get(result.size() - 1);
    }
}