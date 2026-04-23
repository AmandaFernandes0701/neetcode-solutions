class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stackNums2 = new Stack<>();
        HashMap<Integer, Integer> mapNextGreaterElement = new HashMap<>();
        int[] arrayResult = new int[nums1.length];

/*
nums1 = [4,1,2], nums2 = [1,3,4,2]

aeeary result = [-1,3,-1]

num = 2
num    nextGreaterElement (em nums2)
1      3
3      4


2
4




*/

        for(int i = 0; i < nums2.length; i++)
        {
            int num = nums2[i];

            while(!stackNums2.isEmpty() && stackNums2.peek() < num)
            {
                int currElement = stackNums2.pop();
                mapNextGreaterElement.put(currElement, num);
            }
            stackNums2.push(num);
        }
        
        for(int i = 0; i < nums1.length; i++)
        {
            int num = nums1[i];

            if(mapNextGreaterElement.containsKey(num))
                arrayResult[i] = mapNextGreaterElement.get(num);
            
            else
                arrayResult[i] = -1;
        }

        return arrayResult;
    }
}