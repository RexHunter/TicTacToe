package rexxie.condition;

import rexxie.entities.Cell;
import rexxie.entities.CellContent;
import rexxie.grid.Grid;

public class DefaultGameCondition implements GameCondition {
    @Override
    public boolean validate(int insertedRow, int insertedCol, CellContent content, Grid grid) {
        Cell[][] cells = grid.getGrid();
        //check winning in column where was inserted value
        for (int row = 0; row < grid.getRowCount(); row++) {
            if (cells[row][insertedCol].getContent() != content) {
                break;
            }
            if (row == grid.getRowCount() - 1) {
                return true;
            }
        }
        //check winning in row where was inserted value
        for (int col = 0; col < grid.getColCount(); col++) {
            if (cells[insertedRow][col].getContent() != content) {
                break;
            }
            if (col == grid.getColCount() - 1) {
                return true;
            }
        }
        //check winning in main diagonal
        int diagonalItemsCount = (grid.getColCount() + grid.getRowCount()) / 2;
        for (int i = 0; i < diagonalItemsCount; i++) {
            if (cells[i][i].getContent() != content) {
                break;
            }
            if (i == diagonalItemsCount - 1) {
                return true;
            }
        }
        //check winning in alternate diagonal
        for (int i = 0; i < diagonalItemsCount; i++) {
            if (cells[i][diagonalItemsCount - 1 - i].getContent() != content) {
                break;
            }
            if (i == diagonalItemsCount - 1) {
                return true;
            }
        }
        return false;
    }
}