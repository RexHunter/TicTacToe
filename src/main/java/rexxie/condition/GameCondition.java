package rexxie.condition;

import rexxie.entities.CellContent;
import rexxie.grid.Grid;

public interface GameCondition {
    boolean validate(int row, int col, CellContent content, Grid grid);
}
