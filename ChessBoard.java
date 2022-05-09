import java.util.ArrayList;

public class ChessBoard {

    // Two-dimensional matrix, holding the position of the queens
    private int [] [] chessBoard;

    public ChessBoard(int n) {
        this.chessBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = 0;
            }
        }
    }

    public boolean placeQueen(int i, int j) {
        if (i < 0 || i >= chessBoard.length || j < 0 || j >= chessBoard.length) return false;
        if (chessBoard[i][j] == 1) return false;
        chessBoard[i][j] = 1;
        return true;
    }

    public boolean isValidState() {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (chessBoard[i][j] == 1) {
                    for (int k = 0; k < chessBoard.length; k++) {

                        // Checks for any queens horizontally or vertically
                        if (k != j && chessBoard[i][k] == 1 || k != i && chessBoard[i][k] == 1) return false;

                        // Checks for any queens diagonally
                        for (int l = 0; l < chessBoard.length; l++) {
                            if (k == i && l == j) continue;
                            if (Math.abs(k - i) == Math.abs(l - j) && chessBoard[k][l] == 1) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public ArrayList<Integer> getAvailableSpotsInColumn(int col) {
        if (col < 0 || col >= chessBoard.length) throw new IllegalArgumentException("Invalid column") ;

        // Checks for any spots where we can place the queen
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < chessBoard.length; i++) {
            if (chessBoard[i][col] == 0){
                arr.add(i);
            }
        }
        return arr;
    }

    @Override
    public String toString(){
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
        return "";
    }
}
