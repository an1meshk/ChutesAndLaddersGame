package com.animesh.chutesladders.board;

import java.util.Map;

/**
 * Created by Animesh Kumar on 11-08-2018.
 */
public interface IGameBoard {
    Map<Integer, Integer> getChute();

    Map<Integer, Integer> getLadder();

    int size();
}
