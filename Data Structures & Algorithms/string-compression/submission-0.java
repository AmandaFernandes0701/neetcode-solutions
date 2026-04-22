class Solution {
    public int compress(char[] chars)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < chars.length)
        {
            char currChar = chars[i];
            int count = 0;

            sb.append(currChar);

            while(i < chars.length && currChar == chars[i])
            {
                count++;
                i++;
            }

            if(count > 1)
                sb.append(Integer.toString(count));
        }

        for(int j = 0; j < sb.length(); j++)
            chars[j] = sb.charAt(j);

        return sb.length();
    }
}