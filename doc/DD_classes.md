```mermaid
---
title: D&D class diagram
---
classDiagram

class Menu {
    +displayGameStart() : void
    +displayTurnNumber()
    +playerMenu(List<Person> players)
}


class Person {
    getTypeString() String*
}
<<Abstract>> Person

