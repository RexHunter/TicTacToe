package rexxie.entities;

public class Player {
    private String name;
    private CellContent cellContentType;

    private Player() {
    }

    public String getName() {
        return name;
    }

    public CellContent getCellContent() {
        return cellContentType;
    }

    public static Builder createBuilder() {
        return new Player().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setName(String name) {
            Player.this.name = name;
            return this;
        }

        public Builder setCellContent(CellContent content) {
            Player.this.cellContentType = content;
            return this;
        }

        public Player build() {
            return Player.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        return cellContentType == player.cellContentType;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cellContentType != null ? cellContentType.hashCode() : 0);
        return result;
    }
}
