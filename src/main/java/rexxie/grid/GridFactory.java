package rexxie.grid;

public class GridFactory {
    public Grid getGrid(Grids grid) {
        switch (grid) {
            case NORMAL:
                return new DefaultGrid();
            default:
                return new DefaultGrid();
        }
    }
}
