class Solution {
    public int firstUniqChar(String s) {

        int[] countFrequency = new int[26];

        for(int i = 0; i < s.length(); i++)
        {
            int currChar = s.charAt(i);
            countFrequency[currChar - 'a']++;
        }

        for(int i = 0; i < s.length(); i++)
        {
            int currChar = s.charAt(i);
            if(countFrequency[currChar - 'a'] == 1) return i;
        } 

        return -1;
    }
}