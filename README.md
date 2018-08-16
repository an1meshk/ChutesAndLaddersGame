# Game Description
#### Game board is of size 10 x 10, and maximum number on the game board is 100
#### This Chutes and Ladders game is played by minimum 2 and maximum of 4 players
#### A spinner is used to navigate ahead in the game, and spinner outcome will be between 1 & 6
#### The spinner spins when character "r" is pressed and player is moved to next position accordingly
#### Each player will get a chance to spin alternatively. In case the spin outcome is 6 for any player, the turn continues.
#### The first player to reach square #100 will be the “Winner”


# Class Description
#### GameRunner.java  - This is the main Java class which will be launched on start-up
#### LoadConfiguration.java - Spring Java configuration class which bootstrap the application beans
#### IGame.java - Interface defining the game contract
#### ChutesAndLaddersGame.java - Implements IGame interface. This class is the core driver of the application, it contains the business logic for chute and ladder game
#### ISpinner.java - Interface defining the contract for spin
#### SixPieSpinner.java - Implements ISpinner interface. Provides the implementation for spin
#### IGameBoard.java - Interface defining the contract for Game Board
#### TenByTenGameBoard.java - Implements IGameBoard interface. Stores the starting and ending positions of chute and ladder on the game board
#### Player.java - POJO class to represent the player's instance


# How to Run
#### java -jar chutesandladdersgame-1.0-SNAPSHOT.jar
#### Note - Dependent libraries are kept under libs folder
