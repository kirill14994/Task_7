import java.util.LinkedList;
import java.util.List;

class NQueensProblem {

    private int size;

    private List<QueenBoard> solutions;

    public NQueensProblem(int size1) {
        this.size = size1;
        this.solutions = new LinkedList<QueenBoard>();
        solve(size1);
    }

    public void solve(int size) {
        QueenBoard board = new QueenBoard(size);
        LogicalBoard logicalBoard = new LogicalBoard(size);
        solve(board, logicalBoard, 0, size);
    }

    public List<QueenBoard> getAllSolutions() {
        return solutions;
    }

    private void solve(QueenBoard board, LogicalBoard logicalBoard,
            int rowNumber, int size) {
        if (rowNumber == size) {
            solutions.add(board);
            return;
        }
        for (int column = 0; column < size; column++) {
            if (logicalBoard.getPossible(rowNumber, column)) {
                QueenBoard newBoard = new QueenBoard(board);
                newBoard.setHasQueen(rowNumber, column, true);
                LogicalBoard newLogicalBoard = new LogicalBoard(logicalBoard);
                newLogicalBoard.setPossible(rowNumber, column, false);
                updateBoard(rowNumber, column, newLogicalBoard, size);
                solve(newBoard, newLogicalBoard, rowNumber + 1, size);
            }
        }
    }

    private void updateBoard(int row, int col, LogicalBoard logicalBoard, int size) {
        updateRow(row, logicalBoard, size);
        updateColumn(col, logicalBoard, size);
        updateDiagonal(row, col, logicalBoard, size);
        updateDiagonal(row, col, logicalBoard, size);
        updateDiagonal(row, col, logicalBoard, size);
        updateDiagonal(row, col, logicalBoard, size);
    }

    private void updateRow(int row, LogicalBoard logicalBoard, int size) {
        for (int j = 0; j < size; j++) {
            logicalBoard.setPossible(row, j, false);
        }
    }

    private void updateColumn(int col, LogicalBoard logicalBoard, int size) {
        for (int j = 0; j < size; j++) {
            logicalBoard.setPossible(j, col, false);
        }
    }

    private void updateDiagonal(int row, int col, LogicalBoard logicalBoard, int size) {

        // update the diagonals
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            logicalBoard.setPossible(r, c, false);
            r--;
            c--;
        }
        r = row;
        c = col;
        while (r < size && c < size) {
            logicalBoard.setPossible(r, c, false);
            r++;
            c++;
        }
        r = row;
        c = col;
        while (r < size && c >= 0) {
            logicalBoard.setPossible(r, c, false);
            r++;
            c--;
        }
        r = row;
        c = col;
        while (r >= 0 && c < size) {
            logicalBoard.setPossible(r, c, false);
            r--;
            c++;
        }
    }

}