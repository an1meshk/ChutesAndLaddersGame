package com.animesh.chutesladders.board;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Animesh Kumar on 11-08-2018.
 * <p>
 * Class implementing ISpinner
 */
@Component
public class SixPieSpinner implements ISpinner {
    protected int sides;

    public SixPieSpinner() {
        sides = 6;
    }

    @Override
    public int spinnerSize() {
        return sides;
    }

    @Override
    public int spin() {
        Random generator = new Random();
        int value = generator.nextInt(sides + 1);
        return (value == 0) ? 1 : value;
    }
}
