package rexxie.grid;


import rexxie.entities.Cell;

public class DefaultGrid extends Grid {
    public static final int ROWS = 3;
    public static final int COLS = 3;

    public DefaultGrid() {
        super(ROWS, COLS);
    }

    @Override
    protected void generateGrid(int rowCount, int colCount) {
        grid = new Cell[rowCount][colCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                grid[row][col] = new Cell();
            }
        }
    }
}
