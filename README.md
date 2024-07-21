# Donjons & Dragons

A simple text-based game inspired by the famous tabletop RPG game Dungeons & Dragons.
The title of the project is in French but I will write the rest of the documentation in English.

The goal of this project is to demonstrate my ability to create a basic **Java** application, including the main concepts of Object-Oriented Programming (OOP).

## Overview
This project is a Java application with a text console interface. It includes a main class that initiates a game loop. The project structure and dependencies are defined in the `pom.xml` file.

## Code Flow
1. **Main Class Execution**: The `Main` class is executed, starting the application.
2. **Game Loop**: Inside the `main` method, a `do-while` loop continuously creates a new `Game` object and calls its `play` method.
3. **Game Logic**: The `play` method in the `Game` class contains the core game logic.

## Play logic

The `play` method in the `Game` class is responsible for managing the main game loop and handling the core game logic. Here is a detailed breakdown of what the `play` method does:

1. **Initialization**:
    - Initializes the turn counter (`turnCount`) and a flag to indicate if the game is over (`gameOver`).
    - Prints the game title using the `UserInterface` (`ui`).
    - Creates the players by calling `ui.getPlayers()`.

2. **Board Setup**:
    - Creates the game board by instantiating the `Board` class with a specific `BoardType`, passing the list of players.

3. **Main Game Loop**:
    - Runs a loop until the `gameOver` flag is set to `true`.
    - For each turn, it displays the turn number and calls the `gameTurn` method to handle the actions for each player.
    - If a player goes out of the board, it catches the `PersonOutOfBoard` exception, displays a message, and sets the `gameOver` flag to `true`.
4. **Game Turns**:
    - The `gameTurn` method handles the actions for each player during a turn, including moving the player, interacting with the board square, and checking for game-over conditions.

5. **Game Over**:
    - Displays the game over message and shows the end-of-game menu.


## Building and Running the Application

### Prerequisites
- **Java**: Ensure that Java JDK is installed on your system. You can verify by running:
    ```sh
    java -version
    ```
  If not installed, download and install the latest version of Java from the [official website](https://www.oracle.com/java/technologies/downloads/).

- **Maven**: Verify Maven installation by running:
    ```sh
    mvn -v
    ```
    If not installed, download and install Maven from the [official website](https://maven.apache.org/download.cgi).
### Using Maven

1. **Build the Project**: Navigate to the project directory and run:
    ```sh
    mvn clean install
    ```

2. **Run the Project**: Execute the application using:
    ```sh
    mvn exec:java -Dexec.mainClass="main.java.dd.Main"
    ```

### Using IntelliJ IDEA

1. **Build the Project**: Open the Maven tool window (`View > Tool Windows > Maven`), click on the `Lifecycle` node, and double-click `install` to build the project.

4. **Run the Project**: Create a run configuration:
    - Go to `Run > Edit Configurations`.
    - Click the `+` icon and select `Application`.
    - Set the `Main class` to `main.java.dd.Main` and click `OK`.
    - Run the project by selecting `Run > Run 'Main'`.

