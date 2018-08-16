package com.animesh.chutesladders.vo;

/**
 * Created by Animesh Kumar on 11-08-2018.
 * <p>
 * Class to represent the player instance
 */
public class Player {
    private int position;
    private String name;

    public Player() {
    }

    public Player(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public void newPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
