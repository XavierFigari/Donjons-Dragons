package DD.board;

import DD.board.enemies.SquareDragon;
import DD.board.enemies.SquareGoblin;
import DD.board.enemies.SquareSorcerer;
import DD.board.potions.SquarePotionBig;
import DD.board.potions.SquarePotionStd;
import DD.board.spells.SquareFireball;
import DD.board.spells.SquareLightning;
import DD.board.weapons.SquareHammer;
import DD.board.weapons.SquareSword;
import DD.board.weapons.SquareWeapon;

import java.util.List;

public class Board {

    private List<Square> squares;

    public Board(BoardType boardType) {
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
