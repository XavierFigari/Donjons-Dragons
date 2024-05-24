```mermaid
classDiagram

    class Person {
        <<abstract>>
        -String name
        -int life
        -int strength
        -DefensiveTool defensiveTool
        -OffensiveTool offensiveTool
        -int position
        +Person(String name)
        +reset()* : void
        +toString() : String
    }

    class Warrior {
        +Warrior(String name)
        +reset() : void
        +getTypeString() : String
    }

    class Wizard {
        +Wizard(String name)
        +reset() : void
        +getTypeString() : String
    }

    class OffensiveTool {
        <<abstract>>
        -int attackLevel
        +OffensiveTool()
        +getAttackLevel() : int
    }

    class UserInterface {
        +getPlayers(List<Person> players) : List<Person>
        +printBox(String color, String text) : void
        +displayWinner(String playerName) : void
        +askToThrowDice() : void
        +getFleeMove() : int
    }

    class Game {
        -final UserInterface userInterface
        -final Board board
        +Game(UserInterface userInterface)
        +play(List<Person> players) : void
        -gameTurn(List<Person> players, int turnCount) : boolean
        -throwDice() : int
    }

   class Axe {
        +Axe(int attackLevel, String name)
    }

    class Fireball {
        +Fireball(int attackLevel, String name)
    }

    class Lightning {
        +Lightning(int attackLevel, String name)
    }

    class Sword {
        +Sword(int attackLevel, String name)
    }

     class Board {
        -List<Square> squares
        +Board(BoardType boardType, UserInterface ui, List<Person> players)
        +getSquares() : List<Square>
        +getSquare(int position) : Square
    }

    direction LR
    class Square {
        <<abstract>>
        +Square()
    }

    class SquareEmpty {
        +SquareEmpty(UserInterface ui)
    }

    class SquareDragon {
        +SquareDragon(UserInterface ui)
    }

    class SquareGoblin {
        +SquareGoblin(UserInterface ui)
    }

    class SquareSorcerer {
        +SquareSorcerer(UserInterface ui)
    }

    class SquarePotionStd {
        +SquarePotionStd(UserInterface ui)
    }

    class SquarePotionBig {
        +SquarePotionBig(UserInterface ui)
    }

    class SquareFireball {
        +SquareFireball(UserInterface ui, List<Wizard> wizards)
    }

    class SquareLightning {
        +SquareLightning(UserInterface ui, List<Wizard> wizards)
    }

    class SquareAxe {
        +SquareAxe(UserInterface ui, List<Warrior> warriors)
    }

    class SquareSword {
        +SquareSword(UserInterface ui, List<Warrior> warriors)
    }

    Board --> Square : Contains
    Square ..|> SquareEmpty
    Square ..|> SquareDragon
    Square ..|> SquareGoblin
    Square ..|> SquareSorcerer
    Square ..|> SquarePotionStd
    Square ..|> SquarePotionBig
    Square ..|> SquareFireball
    Square ..|> SquareLightning
    Square ..|> SquareAxe
    Square ..|> SquareSword



    Game --> Board : Uses
    Game --> Person : Uses
    Person <|-- Warrior
    Person <|-- Wizard
    Warrior --> Axe : Uses
    Warrior --> Sword : Uses
    Wizard --> Fireball : Uses
    Wizard --> Lightning : Uses
    Axe <|-- OffensiveTool
    Fireball <|-- OffensiveTool
    Lightning <|-- OffensiveTool
    Sword <|-- OffensiveTool
    Game --> UserInterface : Uses
    
