package DD.board;

import DD.UserInterface;
import DD.board.enemies.SquareDragon;
import DD.board.enemies.SquareGoblin;
import DD.board.enemies.SquareSorcerer;
import DD.board.potions.SquarePotionBig;
import DD.board.potions.SquarePotionStd;
import DD.board.tools.SquareFireball;
import DD.board.tools.SquareLightning;
import DD.board.tools.SquareAxe;
import DD.board.tools.SquareSword;
import DD.persons.Person;
import DD.persons.Warrior;
import DD.persons.Wizard;

import java.util.List;

public class Board {

    private List<Square> squares;

    // Constructor
    public Board(BoardType boardType, UserInterface ui, List<Person> players) {
        List<Person> warriors = players.stream()
                .filter(p -> p instanceof Warrior)
                .toList();
        
        List<Person> wizards = players.stream()
                .filter(p -> p instanceof Wizard)
                .toList();

        switch (boardType) {
            case TEST -> {
                this.squares = List.of(     // List.of creates an immutable list
//                        new SquareSword(ui, warriors),
//                        new SquareAxe(ui, warriors),
                        new SquareLightning(ui, wizards), // 1
//                        new SquareFireball(ui, wizards),
//                        new SquarePotionStd(ui),
//                        new SquarePotionBig(ui),
//
//                        new SquareDragon(ui),
//                        new SquareGoblin(ui),
                        new SquareSorcerer(ui)
                );
            }
            case IT4 -> {
                this.squares = List.of(     // List.of creates an immutable list
                        new SquareEmpty(ui),
                        new SquareDragon(ui),
                        new SquareSword(ui, warriors),
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
                        new SquareFireball(ui, wizards),
                        new SquareLightning(ui, wizards),
                        new SquareAxe(ui, warriors),
                        new SquareSword(ui, warriors)
                );
            }
            case NORMAL -> {
                this.squares = List.of(
                        new SquareLightning(ui, wizards), // 1
                        new SquareAxe(ui, warriors), // 2
                        new SquareGoblin(ui), // 3
                        new SquareLightning(ui, wizards), // 4
                        new SquareAxe(ui, warriors), // 5
                        new SquareGoblin(ui), // 6
                        new SquarePotionStd(ui), // 7
                        new SquareLightning(ui, wizards), // 8
                        new SquareGoblin(ui), // 9
                        new SquareSorcerer(ui), // 10
                        new SquareAxe(ui, warriors), // 11
                        new SquareGoblin(ui), // 12
                        new SquarePotionStd(ui), // 13
                        new SquareEmpty(ui),
                        new SquareGoblin(ui), // 15
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareGoblin(ui), // 18
                        new SquareSword(ui, warriors), // 19
                        new SquareSorcerer(ui), // 20
                        new SquareGoblin(ui), // 21
                        new SquareAxe(ui, warriors), // 22
                        new SquareLightning(ui, wizards), // 23
                        new SquareGoblin(ui), // 24
                        new SquareSorcerer(ui), // 25
                        new SquareSword(ui, warriors), // 26
                        new SquareGoblin(ui), // 27
                        new SquarePotionBig(ui), // 28
                        new SquareEmpty(ui),
                        new SquareGoblin(ui), // 30
                        new SquarePotionStd(ui), // 31
                        new SquareSorcerer(ui), // 32
                        new SquarePotionStd(ui), // 33
                        new SquareEmpty(ui),
                        new SquareSorcerer(ui), // 35
                        new SquareSorcerer(ui), // 36
                        new SquareSorcerer(ui), // 37
                        new SquareAxe(ui, warriors), // 38
                        new SquarePotionStd(ui), // 39
                        new SquareSorcerer(ui), // 40
                        new SquarePotionBig(ui), // 41
                        new SquareSword(ui, warriors), // 42
                        new SquarePotionStd(ui), // 43
                        new SquareSorcerer(ui), // 44
                        new SquareDragon(ui), // 45
                        new SquareEmpty(ui),
                        new SquareSorcerer(ui), // 47
                        new SquareFireball(ui, wizards), // 48
                        new SquareFireball(ui, wizards), // 49
                        new SquareEmpty(ui),
                        new SquareEmpty(ui),
                        new SquareDragon(ui), // 52
                        new SquareSword(ui, warriors), // 53
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
