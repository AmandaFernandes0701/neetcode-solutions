class Solution {
    public int mySqrt(int x) {

        if(x == 0) return 0;

        long result = 1;

        for(long i = 2; i < x; i++)
        {
            if(i * i <= x) result = i;
            else break;
        }

        return (int)result;     
    }
}