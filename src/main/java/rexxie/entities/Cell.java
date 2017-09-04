package rexxie.entities;

public class Cell {
    private CellContent content;
    private boolean hasSet;

    public Cell(CellContent content) {
        this.content = content;
    }

    public Cell() {
        this.content = CellContent.EMPTY;
    }

    public void clean() {
        content = null;
        hasSet = false;
    }

    public CellContent getContent() {
        return content;
    }

    public void setContent(CellContent content) {
        this.content = content;
        hasSet = true;
    }

    public boolean hasSet() {
        return hasSet;
    }
}