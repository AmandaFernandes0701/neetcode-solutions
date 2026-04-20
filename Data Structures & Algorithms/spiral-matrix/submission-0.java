class Solution {

    private List<Integer> finalList = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {

        int linhas = matrix.length;
        int colunas = matrix[0].length;

        boolean[][] visited = new boolean[linhas][colunas];

        visitAllMatrix(matrix, visited, 0, 0);

        return finalList;
        
    }

    public void visitAllMatrix(int[][] matrix, boolean[][] visited, int i, int j)
    {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] == true)
            return;

        // vai pra direita
        while(j >= 0 && j < matrix[0].length && visited[i][j] == false)
        {
            visited[i][j] = true;
            finalList.add(matrix[i][j]);
            j++;
        }
        i++;
        j--;

        // vai pra baixo
        while(i >= 0 && i < matrix.length && visited[i][j] == false)
        {
            visited[i][j] = true;
            finalList.add(matrix[i][j]);
            i++;
        }
        i--;
        j--;

        // vai pra esquerda
        while(j >= 0 && j < matrix[0].length && visited[i][j] == false)
        {
            visited[i][j] = true;
            finalList.add(matrix[i][j]);
            j--;
        }
        i--;
        j++;

        // vai pra cima
        while(i >= 0 && i < matrix.length && visited[i][j] == false)
        {
            visited[i][j] = true;
            finalList.add(matrix[i][j]);
            i--;
        }
        i++;
        j++;

        // repete processo denovo
        visitAllMatrix(matrix, visited, i, j);

        return;
    }
}
