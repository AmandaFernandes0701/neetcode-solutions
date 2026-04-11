class Solution {
    public boolean isAnagram(String s, String t) {

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
