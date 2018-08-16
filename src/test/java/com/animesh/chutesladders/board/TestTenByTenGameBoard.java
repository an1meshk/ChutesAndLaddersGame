package com.animesh.chutesladders.board;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Animesh Kumar on 12-08-2018.
 */
public class TestTenByTenGameBoard {

    private TenByTenGameBoard gameBoard;

    @Before
    public void setup() {
        gameBoard = new TenByTenGameBoard();
    }

    @Test
    public void chuteBoundaryTest() {

        Map<Integer, Integer> chuteMap = gameBoard.getChute();

        for (Map.Entry<Integer, Integer> chute : chuteMap.entrySet()) {
            assertThat(chute.getKey(),
                    anyOf(lessThanOrEqualTo(100), greaterThanOrEqualTo(1)));
            assertThat(chute.getValue(),
                    anyOf(lessThanOrEqualTo(100), greaterThanOrEqualTo(1)));
        }
    }

    @Test
    public void ladderBoundaryTest() {

        Map<Integer, Integer> ladderMap = gameBoard.getLadder();

        for (Map.Entry<Integer, Integer> ladder : ladderMap.entrySet()) {
            assertThat(ladder.getKey(),
                    anyOf(lessThanOrEqualTo(100), greaterThanOrEqualTo(1)));
            assertThat(ladder.getValue(),
                    anyOf(lessThanOrEqualTo(100), greaterThanOrEqualTo(1)));
        }
    }
}
