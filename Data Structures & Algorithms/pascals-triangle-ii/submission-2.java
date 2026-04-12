class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();
        result.add(1);

        for(int i = 1; i < rowIndex + 1; i++)
        {
            List<Integer> currList = new ArrayList<>();
            currList.add(1);

            for(int j = 0; j < result.size() - 1; j++)
            {
                int sum = result.get(j) + result.get(j+1);
                currList.add(sum);
            }

            currList.add(1);
            result = currList;
        }

        return result;
    }
}