class Solution {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> currList = new ArrayList<>();
        boolean[] seenNums = new boolean[nums.length];

        return dfsAllPermutations(nums, currList, seenNums);
    }

    public List<List<Integer>> dfsAllPermutations(int[] nums, List<Integer> currList, boolean[] seenNums)
    {
        if(currList.size() == nums.length)
        {
            List<Integer> list = new ArrayList<>(currList);
            resultList.add(list);
            return resultList;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(seenNums[i] == false)
            {
                currList.add(nums[i]);
                seenNums[i] = true;
                dfsAllPermutations(nums, currList, seenNums);
                currList.remove(currList.size() - 1);
                seenNums[i] = false;
            }
        }

        return resultList;
    }
}
