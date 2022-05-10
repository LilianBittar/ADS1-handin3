public class QueenSolver {

    private ChessBoard chessBoard;

    public QueenSolver(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }


    // if we find solution, print it
    public void solve(int col){
        if (chessBoard.numberOfQueens() == chessBoard.getSize()) {
            chessBoard.toString();
            System.out.println();
            return;
        } else {
            for (int i : chessBoard.getAvailableSpotsInColumn(col)) {
                chessBoard.placeQueen(i, col);
                if (chessBoard.isValidState()) {
                    solve(col +1);
                }
                chessBoard.removeQueen(i, col);
            }
        }
    }
}
