class Solution {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<Integer> currList = new ArrayList<>();

        return dfsFindAllCombinationEqualsTarget(currList, nums, 0, 0, target);
        
    }

    public List<List<Integer>> dfsFindAllCombinationEqualsTarget(List<Integer> currList, int[] nums, int idx, int currSum, int target)
    {
        if(idx == nums.length || currSum > target)
            return resultList;

        if(currSum == target)
        {
            List<Integer> list = new ArrayList<>(currList);
            resultList.add(list);
            return resultList;
        }

        // não adiciona o numero atual e vai pro próximo num
        dfsFindAllCombinationEqualsTarget(currList, nums, idx + 1, currSum, target);

        // adiciona novamente o mesmo numero atual
        currList.add(nums[idx]);
        dfsFindAllCombinationEqualsTarget(currList, nums, idx, currSum + nums[idx], target);
        currList.remove(currList.size()-1);

        return resultList;
    }

}


