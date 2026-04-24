class Solution {
    public int mySqrt(int x) {                                              

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