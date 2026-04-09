# college-jdnd-project

A turn-based strategy game inspired by DnD mechanics, developed in Java.
The project focuses on object-oriented design, game loop structure, and implementing data-driven gameplay systems.

## Requirements

* JDK 21
* Windows (for the provided `run.bat` file)

The project was developed using JDK 21 in Eclipse.
If needed, it can be rebuilt and executed in any Java-supported IDE.

## How to Run

1. Clone or download the repository
2. Navigate to the `out` directory
3. Run `run.bat`

Alternatively, import the project into an IDE and run it directly.

## Game Overview

* The game board is represented as a 2D matrix rendered in the console
* Players take turns performing actions within a controlled game loop
* Weapons are distributed across the map and can be collected during movement
* Each player maintains a stack-based inventory of collected weapons
* Player encounters trigger a battle sequence

## Combat System

* Combat is resolved using a rule-based system built on weapon priorities:
  * FIREBALL defeats SWORD
  * SWORD defeats MAGIC_RING
  * MAGIC_RING defeats FIREBALL
* Each player uses the top weapon from their stack
* If both players use the same weapon, the attacker loses
* Players without available weapons automatically lose the encounter

## Technical Design

* Object-oriented structure with separation between game logic, entities, and board representation
* Turn-based game loop controlling player actions and state transitions
* Stack data structure used for managing player inventories
* Modular combat system designed around rule-based interactions
