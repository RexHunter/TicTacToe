package rexxie.renders;


import rexxie.entities.Cell;
import rexxie.entities.CellContent;
import rexxie.grid.Grid;

public class ConsoleGridRenderer implements Renderable {

    @Override
    public void render(Grid grid) {
        Cell[][] cells = grid.getGrid();

        for (int row = 0; row < grid.getRowCount(); row++) {
            System.out.print("|");
            for (int col = 0; col < grid.getColCount(); col++) {
                CellContent content = cells[row][col].getContent();
                System.out.print(prepareContentForDrawing(content) + "|");
            }
            System.out.println();
        }
    }

    private String prepareContentForDrawing(CellContent content) {
        switch (content) {
            case CROSS:
                return "X";
            case NOUGHT:
                return "O";
            default:
                return "_";
        }
    }
}
