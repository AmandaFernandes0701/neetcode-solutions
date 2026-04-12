class Solution {
    public int lengthOfLastWord(String s) {

        int currIdx = s.length() - 1;
        int countLength = 0;

        while(s.charAt(currIdx) == ' ')
            currIdx--;
        
        while(currIdx >= 0 && s.charAt(currIdx) != ' ')
        {
            countLength++;
            currIdx--;
        }

        return countLength;       
    }
}