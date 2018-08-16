package com.animesh.chutesladders.board;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Animesh Kumar on 11-08-2018.
 * <p>
 * Game board class initialise chute and ladder Maps on bean
 * creation.
 */
@Component
public class TenByTenGameBoard implements IGameBoard {
    protected static final Map<Integer, Integer> LADDER = new HashMap<>();
    protected static final Map<Integer, Integer> CHUTE = new HashMap<>();

    static {
        CHUTE.put(98, 78);
        CHUTE.put(95, 75);
        CHUTE.put(93, 73);
        CHUTE.put(87, 24);
        CHUTE.put(64, 60);
        CHUTE.put(62, 19);
        CHUTE.put(56, 53);
        CHUTE.put(47, 26);
        CHUTE.put(49, 11);
        CHUTE.put(16, 6);

        LADDER.put(1, 38);
        LADDER.put(4, 14);
        LADDER.put(9, 31);
        LADDER.put(28, 84);
        LADDER.put(21, 42);
        LADDER.put(36, 44);
        LADDER.put(51, 67);
        LADDER.put(71, 91);
        LADDER.put(80, 100);
    }

    protected int size;


    public TenByTenGameBoard() {
        size = 100;
    }

    @Override
    public Map<Integer, Integer> getChute() {
        return CHUTE;
    }

    @Override
    public Map<Integer, Integer> getLadder() {
        return LADDER;
    }

    @Override
    public int size() {
        return size;
    }

}
