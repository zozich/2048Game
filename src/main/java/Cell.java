public class Cell {
    private Integer value;

    public Cell() {
    }

    public Cell(Integer value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == null || value == 0;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
