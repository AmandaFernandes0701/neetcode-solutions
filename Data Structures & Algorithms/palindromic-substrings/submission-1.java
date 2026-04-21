class Solution {
    public int countSubstrings(String s) {

        int count = 0;

        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                String str = s.substring(i, j + 1);
                StringBuilder sb = new StringBuilder(str);
                String reversed = sb.reverse().toString();

                if(str.equals(reversed)) count++;
            }
        }

        return count;
        
    }
}
