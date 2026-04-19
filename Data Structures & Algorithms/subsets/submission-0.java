class Solution {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> currList = new ArrayList<>();

        return dfsFindAllSubsets(nums, 0, currList);  
    }

    public List<List<Integer>> dfsFindAllSubsets(int[] nums, int index, List<Integer> currList)
    {
        if(index == nums.length)
        {

            resultList.add(new ArrayList<>(currList));
            return resultList;
        }

        // não add num atual
        dfsFindAllSubsets(nums, index + 1, currList);

        // add num atual
        currList.add(nums[index]);
        dfsFindAllSubsets(nums, index + 1, currList);     
        currList.remove(currList.size()-1);

        return resultList;
    }



}
