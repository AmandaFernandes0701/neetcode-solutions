class Solution {
    public int countSubstrings(String s) {

        int count = 0;
        int length = s.length();

        for(int i = 0; i < length; i++)
        {
            // se for palindromo com length par
            int right = i;
            int left = i;

            while(left >= 0 && right < length)
            {
                if(s.charAt(left) == s.charAt(right))
                {   
                    left--;
                    right++;
                    count++;
                }
                else break;
            }

            // se for palindromo com length ímpar
            right = i;
            left = right - 1;

            while(left >= 0 && right < length)
            {
                if(s.charAt(left) == s.charAt(right))
                {   
                    left--;
                    right++;
                    count++;
                }
                else break;
            }
        }

        return count;       
    }
}
