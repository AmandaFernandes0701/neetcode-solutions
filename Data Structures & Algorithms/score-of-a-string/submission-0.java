class Solution {
    public int scoreOfString(String s) {

        int totalSum = 0;
        
        for(int i = 0; i < s.length() - 1; i++)
        {
            char currChar = s.charAt(i);
            char nextChar = s.charAt(i+1);

            totalSum += Math.abs(nextChar - currChar);
        }

        return totalSum;
    }
}