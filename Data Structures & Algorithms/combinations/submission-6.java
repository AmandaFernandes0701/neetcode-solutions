class Solution {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> currList = new ArrayList<>();

        return dfsAllCombinationsWithLengthK(currList, 1, n, k);       
    }

    public List<List<Integer>> dfsAllCombinationsWithLengthK(List<Integer> currList, int currNum, int n, int k)
    {
        if(currList.size() == k)
        {
            resultList.add(new ArrayList<>(currList));
            return resultList;
        }

        if(currNum == n + 1)
            return resultList;

        // não add currNum
        dfsAllCombinationsWithLengthK(currList, currNum + 1, n, k);

        // add currNum
        currList.add(currNum);
        dfsAllCombinationsWithLengthK(currList, currNum + 1, n, k);
        currList.remove(currList.size() - 1);

        return resultList;
    }
}