public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(4);
        QueenSolver queenSolver = new QueenSolver(chessBoard);
        queenSolver.solve(0);
    }
}
