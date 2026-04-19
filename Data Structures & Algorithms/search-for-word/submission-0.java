class Solution {

    public boolean exist(char[][] board, String word) {

        int len = word.length();
        int linhas = board.length;
        int colunas = board[0].length;
        boolean[][] visitedBoard = new boolean[linhas][colunas];

        for(int i = 0; i < linhas; i++)
        {
            for(int j = 0; j < colunas; j++)
                if(findWord(board, word, visitedBoard, 0, i, j)) return true;
        }
        
        return false;  
    }

    public boolean findWord(char[][] board, String word, boolean[][] visitedBoard, int index, int i, int j)
    {
        if(index == word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || board[i][j] != word.charAt(index) || visitedBoard[i][j] == true) return false;

        // marca como visitado
        visitedBoard[i][j] = true;

        // procura em cima
        boolean foundEmcima = findWord(board, word, visitedBoard, index + 1, i - 1, j);

        // procura embaixo
        boolean foundEmbaixo = findWord(board, word, visitedBoard, index + 1, i + 1, j);

        // procura na esquerda
        boolean foundEsquerda = findWord(board, word, visitedBoard, index + 1, i, j - 1);

        // procura na direita
        boolean foundDireita = findWord(board, word, visitedBoard, index + 1, i, j + 1);

        visitedBoard[i][j] = false;

        return (foundEmcima || foundEmbaixo || foundEsquerda || foundDireita);
    }
}








