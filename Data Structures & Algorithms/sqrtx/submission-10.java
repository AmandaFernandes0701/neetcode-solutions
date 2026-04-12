class Solution {
    public int mySqrt(int x) {
/*  0    1    2    3    4    5    6    7    8    9    10    11    12    13
                   L                                         
                   R
                   M
*/
        long left = 0;
        long right = x;

        while(left <= right)
        {
            long middle = left + (right - left) / 2;

            if(middle * middle == x)
                return (int)middle;

            else if(middle * middle > x)
                right = middle - 1;

            else
                left = middle + 1;
        }

        return (int)right;
    }
}