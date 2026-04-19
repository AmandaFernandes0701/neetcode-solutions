class Solution {
    public boolean isPerfectSquare(int num) {

        long left = 0;
        long right = num;

        while(left <= right)
        {
            long middle = left + (right - left) / 2;
            long square = middle * middle;

            if(square == num) return true;

            else if(square > num)
                right = middle - 1;
            
            else
                left = middle + 1;
        }

        return false;      
    }
}