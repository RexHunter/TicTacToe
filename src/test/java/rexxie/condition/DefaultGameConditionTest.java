package rexxie.condition;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import rexxie.entities.Cell;
import rexxie.entities.CellContent;
import rexxie.grid.Grid;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultGameConditionTest {

    @Mock
    private Grid grid;
    private DefaultGameCondition defaultGameCondition;

    @Before
    public void setUp() throws Exception {
        defaultGameCondition = new DefaultGameCondition();
        when(grid.getColCount()).thenReturn(3);
        when(grid.getRowCount()).thenReturn(3);
    }

    @Test
    public void validateHorizontalWon() throws Exception {
        int insertedRow = 0;
        int insertedCol = 0;
        CellContent content = CellContent.CROSS;
        Cell[][] cells = {
                {new Cell(CellContent.CROSS), new Cell(CellContent.CROSS), new Cell(CellContent.CROSS)},
                {new Cell(), new Cell(), new Cell()},
                {new Cell(), new Cell(), new Cell()}
        };
        when(grid.getGrid()).thenReturn(cells);
        assertTrue(defaultGameCondition.validate(insertedRow, insertedCol, content, grid));
    }

    @Test
    public void validateVerticalWon() throws Exception {
        int insertedRow = 0;
        int insertedCol = 0;
        CellContent content = CellContent.CROSS;
        Cell[][] cells = {
                {new Cell(CellContent.CROSS), new Cell(), new Cell()},
                {new Cell(CellContent.CROSS), new Cell(), new Cell()},
                {new Cell(CellContent.CROSS), new Cell(), new Cell()}
        };
        when(grid.getGrid()).thenReturn(cells);
        assertTrue(defaultGameCondition.validate(insertedRow, insertedCol, content, grid));
    }

    @Test
    public void validateDiagonalWon() throws Exception {
        int insertedRow = 0;
        int insertedCol = 0;
        CellContent content = CellContent.CROSS;
        Cell[][] cells = {
                {new Cell(CellContent.CROSS), new Cell(), new Cell()},
                {new Cell(), new Cell(CellContent.CROSS), new Cell()},
                {new Cell(), new Cell(), new Cell(CellContent.CROSS)}
        };
        when(grid.getGrid()).thenReturn(cells);
        assertTrue(defaultGameCondition.validate(insertedRow, insertedCol, content, grid));
    }

    @Test
    public void validateAlternateDiagonalWon() throws Exception {
        int insertedRow = 0;
        int insertedCol = 2;
        CellContent content = CellContent.CROSS;
        Cell[][] cells = {
                {new Cell(), new Cell(), new Cell(CellContent.CROSS)},
                {new Cell(), new Cell(CellContent.CROSS), new Cell()},
                {new Cell(CellContent.CROSS), new Cell(), new Cell()}
        };
        when(grid.getGrid()).thenReturn(cells);
        assertTrue(defaultGameCondition.validate(insertedRow, insertedCol, content, grid));
    }

    @Test
    public void validateWhenNoOneWonTheGame() {
        int insertedRow = 0;
        int insertedCol = 2;
        CellContent content = CellContent.CROSS;
        Cell[][] cells = {
                {new Cell(), new Cell(), new Cell()},
                {new Cell(), new Cell(), new Cell()},
                {new Cell(), new Cell(), new Cell()}
        };
        when(grid.getGrid()).thenReturn(cells);
        assertFalse(defaultGameCondition.validate(insertedRow, insertedCol, content, grid));
    }
}
