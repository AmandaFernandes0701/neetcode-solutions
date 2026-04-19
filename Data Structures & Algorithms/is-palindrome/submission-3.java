class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder fraseLimpa = new StringBuilder();

        for(char c : s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
                fraseLimpa.append(Character.toLowerCase(c));
        }

        return fraseLimpa.toString().equals(fraseLimpa.reverse().toString());       
    }
}
