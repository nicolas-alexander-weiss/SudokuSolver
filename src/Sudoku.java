import java.lang.Math;
import java.util.ArrayList;

public class Sudoku {

    Cell[][] cells;

    ArrayList<Cell>[] lines;

    public Sudoku() {


        byte[] input = {0, 1, 0, 0, 0, 0, 5, 0, 3,
                5, 0, 0, 0, 0, 3, 0, 9, 0,
                6, 7, 3, 0, 0, 0, 0, 0, 0,
                3, 0, 2, 7, 6, 1, 0, 8, 0,
                9, 5, 0, 2, 0, 8, 0, 3, 7,
                0, 8, 0, 3, 5, 9, 1, 0, 4,
                0, 0, 0, 0, 0, 0, 8, 1, 9,
                0, 3, 0, 9, 0, 0, 0, 0, 2,
                2, 0, 8, 0, 0, 0, 0, 5, 0};

        cells = new Cell[9][];

        for (int a = 0; a < 9; a++) {
            cells[a] = new Cell[9];

            for (byte b = 0; b < 9; b++) {

                cells[a][b] = new Cell((byte) (b + 1));
            }

        }


        lines = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            lines[i] = new ArrayList<>();
        }

        for (int i = 0; i < 81; i++) {

            if (input[i] != 0) {

                cells[i / 9][i % 9].swap(cells[i / 9][input[i] - 1]);
                cells[i / 9][i % 9].setFixed(true);

            } else {
                lines[i / 9].add(cells[i / 9][i % 9]);
            }

        }

    }


    public boolean rowsCorrect() {

        for (int i = 0; i < 9; i++) {

            byte[] line = {0, 0, 0, 0, 0, 0, 0, 0};

            for (int h = 0; h < 9; h++) {

                if (line[cells[i][h].getValue()] == 0) {
                    line[cells[i][h].getValue()] = +1;
                } else {
                    return false;
                }

            }

        }

        return true;

    }

    public boolean columnsCorrect() {

        for (int i = 0; i < 9; i++) {

            byte[] line = {0, 0, 0, 0, 0, 0, 0, 0};

            for (int h = 0; h < 9; h++) {

                if (line[cells[h][i].getValue()] == 0) {
                    line[cells[h][i].getValue()] = +1;
                } else {
                    return false;
                }

            }

        }

        return true;
    }

    public boolean fieldsCorrect() {

        for (int i = 0; i < 3; i++) {

            for (int h = 0; h < 3; h++) {

                byte[] field = new byte[9];


                for (int a = 0; a < 3; a++) {

                    for (int b = 0; b < 3; b++) {
                        if (field[cells[i * 3 + a][h * 3 + b].getValue() - 1] == 0) {
                            field[cells[i * 3 + a][h * 3 + b].getValue() - 1] = +1;
                        } else {
                            return false;
                        }

                    }
                }


            }

        }
        return true;

    }

    public boolean isCorrect() {
        
        if (!fieldsCorrect()) {
            return false;
        } else if (!columnsCorrect()) {
            return false;
        } else if (!rowsCorrect()) {
            return false;
        } else {
            return true;
        }
    }

    public void printSudoku() {

        for (int i = 0; i < 81; i++) {


            System.out.print(cells[i / 9][i % 9].getValue() + "  ");

            if ((i + 1) % 9 == 0) {
                System.out.println();
            }


        }
    }





}



















