public class SudokuSolver {

    public static void main(String[] args) {

        Sudoku sudoku = new Sudoku();
        //sudoku.solveSudoku();
        sudoku.printSudoku();
        System.out.println(sudoku.isCorrect());
    }

}
