package DD.board;

import DD.Menu;
import DD.board.squares.Square;
import DD.board.squares.SquareEmpty;
import DD.board.squares.SquareSurprise;
import DD.board.squares.enemies.SquareDragon;
import DD.board.squares.enemies.SquareGoblin;
import DD.board.squares.enemies.SquareSorcerer;
import DD.board.squares.potions.SquarePotionBig;
import DD.board.squares.potions.SquarePotionStd;
import DD.board.squares.spells.SquareFireball;
import DD.board.squares.spells.SquareLightning;
import DD.board.squares.weapons.SquareHammer;
import DD.board.squares.weapons.SquareSword;

import java.util.List;

public class Board {

    // Attributes
    private List<Square> squares;
    private final Menu menu;


    // Constructor
    public Board(BoardType boardType, Menu menu) {

        this.menu = menu;

        switch (boardType) {
            case TEST -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareDragon(),
                        new SquareGoblin()
                );
            }
            case IT4 -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareEmpty(),
                        new SquareDragon(),
                        new SquareSword(),
                        new SquarePotionStd()
                );
            }
            case IT5 -> {
                this.squares = List.of(
                        new SquareDragon(),
                        new SquareEmpty(),
                        new SquareGoblin(),
                        new SquareSorcerer(),
                        new SquarePotionStd(),
                        new SquarePotionBig(),
                        new SquareFireball(),
                        new SquareLightning(),
                        new SquareHammer(),
                        new SquareSword(),
                        new SquareSurprise()
                        );
            }
            case NORMAL -> {
                this.squares = List.of(
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty(),
                        new SquareEmpty()
                );
            }
            case DIFFICULT -> {
                this.squares = List.of(
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

    public Square getSquare(int position) {
        return squares.get(position - 1); // because ArrayList index starts at 0
    }
}
