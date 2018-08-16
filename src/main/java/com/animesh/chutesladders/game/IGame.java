package com.animesh.chutesladders.game;

import java.util.Scanner;

/**
 * Created by Animesh Kumar on 11-08-2018.
 */
public interface IGame {
    void start();

    void run(Scanner scan);

    void stop(Scanner scan);
}
