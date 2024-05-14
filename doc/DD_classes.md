```mermaid
classDiagram

    class Menu {
        +displayGameStart() : void
        +displayTurnNumber()
        +playerMenu(List<Person> players)
    }

    class Game {
        -final Menu menu
        -final Board board
        +Game(Menu menu)
        +play(List<Person> players) : void
        -gameTurn(List<Person> players, int turnCount) : boolean
        -throwDice() : int
    }

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
        +getTypeString() : String
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

    class Weapon {
        +Weapon(int attackLevel, String name)
        +Weapon()
    }

    class Spell {
        +Spell(int attackLevel, String name)
    }

    class DefensiveTool {
        <<abstract>>
        -int defenseLevel
        +DefensiveTool()
        +getDefenseLevel() : int
    }

    class Shield {
        +Shield(int defenseLevel, String name)
        +Shield()
    }

    class Philtre {
        +Philtre(int defenseLevel, String name)
    }

    Game --> Menu : Uses
    Game --> Person : Uses
    Person <|-- Warrior
    Person <|-- Wizard
    Warrior --> Weapon : Uses
    Warrior --> Shield : Uses
    Wizard --> Spell : Uses
    Wizard --> Philtre : Uses
    Weapon <|-- OffensiveTool
    Spell <|-- OffensiveTool
    Shield <|-- DefensiveTool
    Philtre <|-- DefensiveTool