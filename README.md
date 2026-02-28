# college-jdnd-project

A simple turn-based DnD-style board game developed in Java as a college project.
The project focuses on basic game logic, object-oriented design, and turn-based mechanics.

## Requirements

* JDK 21 (recommended)
* Windows (for the provided `run.bat` file)

The project was developed and compiled using JDK 21 in Eclipse IDE.
If it does not run, make sure JDK 21 is installed or rebuild the project using your preferred IDE.

## How to Run

1. Download or clone the repository.
2. Extract the project folder (if downloaded as ZIP).
3. Navigate to the `out` directory.
4. Run `run.bat`.

Alternatively, you can import the project into an IDE (such as Eclipse) and run it directly.

## Game Overview

* The game board is a 2D matrix displayed in the console using symbols.
* Players take turns moving across the board.
* While moving, players can collect weapons found on the map.
* Collected weapons are pushed onto a personal weapon stack.
* When two players encounter each other, a battle occurs.

## Battle System

* During a battle, each player pops the top weapon from their stack.

* The winner is determined by predefined weapon priorities:

  * FIREBALL defeats SWORD
  * SWORD defeats MAGIC_RING
  * MAGIC_RING defeats FIREBALL

* If both players use the same weapon, the loser is the attacker.

* If a player has no weapon available, they automatically lose the round.

## Purpose

This project was created as part of a college assignment to practice:

* Object-oriented programming
* Data structures (stack usage)
* Game loop design
* Basic turn-based mechanics
