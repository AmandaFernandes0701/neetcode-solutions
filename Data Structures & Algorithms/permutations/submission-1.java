class Solution {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> currList = new ArrayList<>();

        return dfsAllPermutations(nums, currList);
    }

    public List<List<Integer>> dfsAllPermutations(int[] nums, List<Integer> currList)
    {
        if(currList.size() == nums.length)
        {
            List<Integer> list = new ArrayList<>(currList);
            resultList.add(list);
            return resultList;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(!currList.contains(nums[i]))
            {
                currList.add(nums[i]);
                dfsAllPermutations(nums, currList);
                currList.remove(currList.size() - 1);
            }
        }

        return resultList;
    }
}
