package DD.board;

import java.util.List;

public class Board {

    private List<Square> squares;

    public Board(BoardType boardType) {
        switch (boardType) {
            case TESTING -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareEmpty(),
                        new SquareEnemy(),
                        new SquareWeapon(),
                        new SquarePotion()
                );
            }
            case EASY -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareEmpty(),
                        new SquareEnemy(),
                        new SquareWeapon()
                );
            }
            case NORMAL -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty()
                );
            }
            case DIFFICULT -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty()
                );
            }
        }
    }

    public List<Square> getSquares() {
        return squares;
    }
}
