class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> mapLetters = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(!mapLetters.containsKey(charS))
            {
                if(mapLetters.values().contains(charT)) return false;
                mapLetters.put(charS, charT);
            }

            // se era pra ser outra letra
            else if(mapLetters.get(charS) != charT)
                return false;
        }

        return true;     
    }
}