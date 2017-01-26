import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Game {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static HashMap<String, Move> moves = new HashMap<String, Move>();

    static {
        moves.put("u", Move.UP);
        moves.put("d", Move.DOWN);
        moves.put("l", Move.LEFT);
        moves.put("r", Move.RIGHT);
    }

    public static void main(String[] args) throws IOException {
        Integer gameFieldSize = readSize();
        clearConsole();
        startGame(gameFieldSize);
    }

    private static void startGame(Integer size) throws IOException {
        Field field = new Field(size);
        while (field.movesAvailable()) {
            field.printField();
            Move move = readMove();
            move.makeMove(field.getGameField());
            field.addNewNumber();
        }
        System.out.println("No more moves available. You have lost the game");
    }

    private static void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n");
        }
    }

    public static Integer readSize() throws IOException {
        Integer gameFieldSize = 0;
        do {
            System.out.println("Please indicate field size");
            String userInput = reader.readLine();
            try {
                gameFieldSize = Integer.parseInt(userInput);
            } catch (Exception e) {
                System.out.println("Error!");
            }
        } while (gameFieldSize <= 1);
        return gameFieldSize;
    }

    public static Move readMove() throws IOException {
        String userInput = "";
        do {
            System.out.println("Make your move (u/d/l/r)");
            userInput = reader.readLine();
        } while (!moves.containsKey(userInput.toLowerCase()));
        clearConsole();
        return moves.get(userInput.toLowerCase());
    }

    public int test() {
        return 1;
    }
}
