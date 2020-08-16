package code.sword;

/**
 * @Desc 12.Exist
 * @date 2020/8/13
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return true;
        }
        int pathLen = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(board, i, j, word, pathLen)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, int i, int j, String word, int pathLen) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pathLen)) {
            return false;
        }
        if (pathLen == word.length()-1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean hasPath =
                isExist(board,i,j-1,word,pathLen+1) ||
                        isExist(board,i,j+1,word,pathLen+1) ||
                        isExist(board,i-1,j,word,pathLen+1) ||
                        isExist(board,i+1,j,word,pathLen+1);
        board[i][j] = tmp;
        return hasPath;
    }
}
