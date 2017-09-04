package rexxie.grid;

import rexxie.entities.Cell;
import rexxie.entities.CellContent;
import rexxie.grid.exceptions.CellIsAlreadyFilled;
import rexxie.grid.exceptions.ValueIsOutOfRangeException;

public abstract class Grid {
    protected Cell[][] grid;
    protected int rowCount;
    protected int colCount;

    public Grid(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        generateGrid(rowCount, colCount);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    protected Cell getGridItem(int row, int col) {
        return grid[row][col];
    }

    public void fillCell(int row, int col, CellContent cellContent) throws ValueIsOutOfRangeException, CellIsAlreadyFilled {
        if(row >= rowCount || col >= colCount) {
            throw new ValueIsOutOfRangeException();
        }

        Cell cell = getGridItem(row, col);
        if (cell.hasSet()) {
            throw new CellIsAlreadyFilled();
        }
        cell.setContent(cellContent);
    }

    public void clear() {
        generateGrid(rowCount, colCount);
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    protected abstract void generateGrid(int rowCount, int colCount);
}
