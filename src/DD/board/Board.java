package DD.board;

import java.util.List;

public class Board {

    private List<Square> squares;

    public Board(BoardType boardType) {
        switch (boardType) {
            case TESTING -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new Empty()
                );
            }
            case EASY -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new Empty(),
                        new Enemy(),
                        new Arm()
                );
            }
            case NORMAL -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new Empty(),
                        new Empty(),
                        new Empty(),
                        new Empty()
                );
            }
            case DIFFICULT -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new Empty(),
                        new Empty(),
                        new Empty(),
                        new Empty(),
                        new Empty(),
                        new Empty()
                );
            }
        }
    }

    public List<Square> getSquares() {
        return squares;
    }
}
