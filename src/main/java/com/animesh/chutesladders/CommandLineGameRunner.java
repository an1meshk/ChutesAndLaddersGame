package com.animesh.chutesladders;

import com.animesh.chutesladders.config.LoadConfiguration;
import com.animesh.chutesladders.game.IGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Animesh Kumar on 11-08-2018.
 *
 * This is the main class which will be launched on startup.
 * Class use AnnotationConfigApplicationContext to create Spring Application Context.
 * LoadConfiguration is the configuration class which reads all stereotype annotations
 * and bootstrap the beans.
 */
public class CommandLineGameRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineGameRunner.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LoadConfiguration.class);
        //Get the game bean to call the start method
        IGame chutesAndLaddersGame = context.getBean(IGame.class);
        logger.info("Launching the Game!!");
        chutesAndLaddersGame.start();
    }
}
