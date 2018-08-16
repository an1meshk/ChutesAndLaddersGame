package com.animesh.chutesladders.game;

import com.animesh.chutesladders.board.IGameBoard;
import com.animesh.chutesladders.board.ISpinner;
import com.animesh.chutesladders.vo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Created by Animesh Kumar on 11-08-2018.
 * <p>
 * This class is core driver of the application,
 * it contains the business logic for chute and ladder
 * game.
 */
@Component
public class ChutesAndLaddersGame implements IGame {

    protected static final int DECIMAL_SIX = 6;
    protected static final int DECIMAL_ONE = 1;
    private static final Logger logger = LoggerFactory.getLogger(ChutesAndLaddersGame.class);
    protected IGameBoard gameBoard;
    protected ISpinner spinner;
    protected List<Player> players;

    @Autowired
    public ChutesAndLaddersGame(IGameBoard gameBoard, ISpinner spinner) {
        this.gameBoard = gameBoard;
        this.spinner = spinner;
    }

    /**
     * Start method which triggers other methods
     */
    public void start() {
        Scanner scan = new Scanner(System.in);
        players = initGame(scan);
        run(scan);
        stop(scan);
    }

    /**
     * core method which contains the main business logic
     * of how chute and ladder game is played
     * <p>
     * Each player will get to play chance by chance, if the spinner
     * outcome is 6 then same player get to spin the spinner again, otherwise
     * next player get the chance
     * <p>
     * If player is on 99, then player need to get exactly spinner count 1 to
     * win.
     * <p>
     * However reaches 100 first, wins the game.
     *
     * @param scan
     */
    public void run(Scanner scan) {
        int roundCount = DECIMAL_ONE;
        boolean isGameOver = false;

        while (!isGameOver) {
            isGameOver = true;
            for (int i = 0; i < players.size(); ) {
                //check whether character r is pressed
                spinIt(scan);

                int count = spinner.spin();
                logger.info("{} spin outcome is {}", players.get(i).getName(), count);

                int previousPosition = players.get(i).getPosition();
                int tempPosition = previousPosition + count;
                isGameOver = false;

                logger.info("{}: {}: {} --> {}", roundCount, players.get(i).getName(), previousPosition, tempPosition);

                // find out the new position
                int newPosition = calculateNewPosition(tempPosition);

                //if new position is greater than 100 then assign
                //new position as previous position, as it can't
                //be greater than 100
                if (newPosition > gameBoard.size()) {
                    newPosition = previousPosition;
                }

                // check is we got the winner, if not then continue
                if (isWinner(newPosition)) {
                    logger.info("Congrats {} is the WINNER!!", players.get(i).getName());
                    return;
                }

                players.get(i).newPosition(newPosition);

                // if spinner outcome is 6 then continue with the same player
                if (count != DECIMAL_SIX) i++;

                roundCount++;
            }
        }
    }

    protected void spinIt(Scanner scan) {
        boolean hasSpun = false;

        logger.info("Press r to spin the spinner!");
        while (!hasSpun) {
            if ("r".equalsIgnoreCase(scan.next())) {
                hasSpun = true;
            } else {
                logger.info("Press r to spin the spinner!");
            }
        }
    }

    /**
     * This method checks if the new position is less than
     * game board size.
     * It also checks whether the new position will cause the
     * go up the ladder or go down the chute.
     *
     * @param tempPosition
     * @return newPosition
     */
    protected int calculateNewPosition(int tempPosition) {

        if (tempPosition > gameBoard.size()) return tempPosition;

        Map<Integer, Integer> chute = gameBoard.getChute();
        Map<Integer, Integer> ladder = gameBoard.getLadder();
        int newPosition = tempPosition;

        //if new position is in chute map then go down the chute
        if (chute.containsKey(tempPosition)) {
            newPosition = chute.get(tempPosition);
            logger.info("--CHUTE--> {}", newPosition);
        }

        // //if new position is in ladder map then go up the ladder
        if (ladder.containsKey(tempPosition)) {
            newPosition = ladder.get(tempPosition);
            logger.info("--LADDER--> {}", newPosition);
        }

        return newPosition;
    }

    /**
     * Method checks whether new position is equal to the
     * game board size. If it is equal then returns true else
     * returns false.
     *
     * @param newPosition
     * @return isWinner
     */
    protected boolean isWinner(int newPosition) {
        return gameBoard.size() == newPosition;
    }

    /**
     * Initializes the components for the game
     * populate the players list, it need each player
     * to start.
     * <p>
     * No. of players should be 2 to 4
     * Throws runtime exception in case above condition
     * is not satisfied.
     *
     * @param scan
     * @return playerlist
     */
    protected List<Player> initGame(Scanner scan) {
        List<Player> playerList = null;

        logger.info("Enter the total number of players: ");
        int playerCount = scan.nextInt();

        if (playerCount < 2 || playerCount > 4) {
            scan.close();
            throw new IllegalArgumentException("Player count should be between 2 & 4");
        }

        playerList = new ArrayList<>();
        Player player = null;

        // get each player name
        for (int i = 0; i < playerCount; i++) {
            logger.info("Enter the name of player no. {}:", i + DECIMAL_ONE);
            player = new Player(scan.next(), 0);
            playerList.add(player);
        }

        return playerList;
    }

    /**
     * Once the winner is found
     * resources will be released and program will be
     * shut down.
     *
     * @param scan
     */
    public void stop(Scanner scan) {
        scan.close();
        exit(0);
    }
}
