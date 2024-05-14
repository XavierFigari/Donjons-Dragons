package DD.board;

import DD.UserInterface;
import DD.board.enemies.SquareDragon;
import DD.board.enemies.SquareGoblin;
import DD.board.enemies.SquareSorcerer;
import DD.board.potions.SquarePotionBig;
import DD.board.potions.SquarePotionStd;
import DD.board.spells.SquareFireball;
import DD.board.spells.SquareLightning;
import DD.board.weapons.SquareHammer;
import DD.board.weapons.SquareSword;

import java.util.List;

public class Board {

    private final UserInterface ui;
    private List<Square> squares;

    public Board(BoardType boardType, UserInterface ui) {
        this.ui = ui;
        switch (boardType) {
            case TEST -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareDragon(ui),
                        new SquareGoblin(ui)
                );
            }
            case IT4 -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareEmpty(ui),
                        new SquareDragon(ui),
                        new SquareSword(ui),
                        new SquarePotionStd(ui)
                );
            }
            case IT5 -> {
                this.squares = List.of(
                        new SquareDragon(ui),
                        new SquareEmpty(ui),
                        new SquareGoblin(ui),
                        new SquareSorcerer(ui),
                        new SquarePotionStd(ui),
                        new SquarePotionBig(ui),
                        new SquareFireball(ui),
                        new SquareLightning(ui),
                        new SquareHammer(ui),
                        new SquareSword(ui),
                        new SquareSurprise(ui)
                );
            }
            case NORMAL -> {
                this.squares = List.of(
                        new SquareSurprise(SquareType.LIGHTNING, ui), // 1
                        new SquareSurprise(SquareType.HAMMER, ui), // 2
                        new SquareGoblin(ui), // 3
                        new SquareSurprise(SquareType.LIGHTNING, ui), // 4
                        new SquareSurprise(SquareType.HAMMER, ui), // 5
                        new SquareGoblin(ui), // 6
                        new SquareSurprise(SquareType.STANDARD_POTION, ui), // 7
                        new SquareSurprise(SquareType.LIGHTNING, ui), // 8
                        new SquareGoblin(ui), // 9
                        new SquareSorcerer(ui), // 10
                        new SquareSurprise(SquareType.HAMMER, ui), // 11
                        new SquareGoblin(ui), // 12
                        new SquareSurprise(SquareType.STANDARD_POTION, ui), // 13
                        new SquareEmpty(ui),
                        new SquareGoblin(ui), // 15
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareGoblin(ui), // 18
                        new SquareSurprise(SquareType.SWORD, ui), // 19
                        new SquareSorcerer(ui), // 20
                        new SquareGoblin(ui), // 21
                        new SquareSurprise(SquareType.HAMMER, ui), // 22
                        new SquareSurprise(SquareType.LIGHTNING, ui), // 23
                        new SquareGoblin(ui), // 24
                        new SquareSorcerer(ui), // 25
                        new SquareSurprise(SquareType.SWORD, ui), // 26
                        new SquareGoblin(ui), // 27
                        new SquareSurprise(SquareType.BIG_POTION, ui), // 28
                        new SquareEmpty(ui),
                        new SquareGoblin(ui), // 30
                        new SquareSurprise(SquareType.STANDARD_POTION, ui), // 31
                        new SquareSorcerer(ui), // 32
                        new SquareSurprise(SquareType.STANDARD_POTION, ui), // 33
                        new SquareEmpty(ui),
                        new SquareSorcerer(ui), // 35
                        new SquareSorcerer(ui), // 36
                        new SquareSorcerer(ui), // 37
                        new SquareSurprise(SquareType.HAMMER, ui), // 38
                        new SquareSurprise(SquareType.STANDARD_POTION, ui), // 39
                        new SquareSorcerer(ui), // 40
                        new SquareSurprise(SquareType.BIG_POTION, ui), // 41
                        new SquareSurprise(SquareType.SWORD, ui), // 42
                        new SquareSurprise(SquareType.STANDARD_POTION, ui), // 43
                        new SquareSorcerer(ui), // 44
                        new SquareDragon(ui), // 45
                        new SquareEmpty(ui),
                        new SquareSorcerer(ui), // 47
                        new SquareSurprise(SquareType.FIREBALL, ui), // 48
                        new SquareSurprise(SquareType.FIREBALL, ui), // 49
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareDragon(ui), // 52
                        new SquareSurprise(SquareType.SWORD, ui), // 53
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareDragon(ui), // 56
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareDragon(ui), // 62
                        new SquareEmpty(ui),
                        new SquareEmpty(ui)
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
