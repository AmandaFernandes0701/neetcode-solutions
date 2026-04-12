class Solution {
    public boolean isSubsequence(String s, String t) {

        if(t.length() < s.length()) return false;
        if(s.isEmpty()) return true;

        int idx = 0;

        for(int i = 0; i < t.length(); i++)
        {
            char currChar = t.charAt(i);
            char wantedChar = s.charAt(idx);

            if(currChar == wantedChar)
            {
                idx++;
                if(idx == s.length()) return true;
            }
        }
        
        return false;    
    }
}