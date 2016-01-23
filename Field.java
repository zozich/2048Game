import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Field {
    private List<List<Cell>> gameField;
    private Integer size;

    public Field(Integer size) {
        gameField = new ArrayList();
        for (int i = 0; i < size; i++) {
            List<Cell> oneRow = new ArrayList();
            for (int j = 0; j < size; j++) {
                oneRow.add(new Cell());
            }
            gameField.add(oneRow);
        }
        this.size = size;
        addNewNumber();
    }

    public List<List<Cell>> addNewNumber() {
        List<Cell> emptyCells = getEmptyCells();
        Cell cellToFill = emptyCells.get(new Random().nextInt(emptyCells.size()));
        cellToFill.setValue(getNewRandomValue());
        return gameField;
    }

    private Integer getNewRandomValue() {
        return Math.random() > 0.85d ? 4 : 2;
    }

    private List<Cell> getEmptyCells() {
        List<Cell> emptyCells = new ArrayList<Cell>();
        for (List<Cell> row : gameField) {
            emptyCells.addAll(row.stream()
                            .filter(cell -> cell.isEmpty())
                            .collect(Collectors.toList())
            );
        }
        return emptyCells;
    }

    public List<List<Cell>> makeMove(Move move) {
        addNewNumber();
        return gameField;
    }

    public Boolean movesAvailable() {
        if (getEmptyCells().size() > 0) {
            return true;
        }
        return false;
    }

    public void printField() {
        for (List<Cell> row : gameField) {
            for (Cell cell : row) {
                System.out.print(cell.getValue() == null ? "-" : cell.getValue() + " ");
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getGameField() {
        return gameField;
    }

    public Integer getSize() {
        return size;
    }
}
