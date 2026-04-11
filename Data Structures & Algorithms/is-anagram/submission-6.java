class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] contagemLetras = new int[26];

        for(char c : s.toCharArray())
            contagemLetras[c - 'a']++;
        
        for(char c : t.toCharArray())
            contagemLetras[c - 'a']--;
        
        for(int count : contagemLetras)
            if(count != 0) return false;
        
        return true;
    }
}
