class Solution {
    public void setZeroes(int[][] matrix) {

        HashSet<Integer> indexRows = new HashSet<>();
        HashSet<Integer> indexColumns = new HashSet<>();

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    indexRows.add(i);
                    indexColumns.add(j);
                }
            }    
        }

        for(Integer row : indexRows)
            for(int j = 0; j < matrix[0].length; j++) matrix[row][j] = 0;
        
        for(Integer column : indexColumns)
            for(int i = 0; i < matrix.length; i++) matrix[i][column] = 0;

    }
}
