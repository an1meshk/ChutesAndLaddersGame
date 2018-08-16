package com.animesh.chutesladders.game;

import com.animesh.chutesladders.board.SixPieSpinner;
import com.animesh.chutesladders.board.TenByTenGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Animesh Kumar on 12-08-2018.
 */
public class TestChutesAndLaddersGame {

    private TenByTenGameBoard gameBoard;
    private SixPieSpinner spinner;
    private ChutesAndLaddersGame game;

    @Before
    public void setup() {
        gameBoard = new TenByTenGameBoard();
        spinner = new SixPieSpinner();
        game = new ChutesAndLaddersGame(gameBoard, spinner);
    }

    @Test
    public void calculateNewPositionBoundaryTest() {
        int result = game.calculateNewPosition(20);

        assertThat(result,
                anyOf(lessThanOrEqualTo(100), greaterThanOrEqualTo(1)));
    }

    @Test
    public void calculateNewPositionBoundaryFailTest() {
        int result = game.calculateNewPosition(101);

        Assert.assertSame(101, result);
    }
}
