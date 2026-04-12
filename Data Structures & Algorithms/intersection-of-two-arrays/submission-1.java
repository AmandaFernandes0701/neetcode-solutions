class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> setNum1 = new HashSet<>();
        for(int num : nums1)
        {
            if(!setNum1.contains(num))
                setNum1.add(num);
        }

        HashSet<Integer> intersection = new HashSet<>();

        for(int num : nums2)
        {
            if(setNum1.contains(num))
                intersection.add(num);
        }

        int[] arrayResult = new int[intersection.size()];
        int i = 0;

        for(int num : intersection)
        {
            arrayResult[i] = num;
            i++;
        }

        return arrayResult;       
    }
}