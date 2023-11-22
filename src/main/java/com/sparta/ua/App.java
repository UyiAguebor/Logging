package com.sparta.ua;

import java.io.IOException;
import java.util.logging.*;

/**
 * Hello world!
 *
 */
public class App {

    public static final Logger logger = Logger.getLogger(App.class.getName());//pulls information from the class itself

    public static void main( String[] args ){
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logFile.log");//if u set to true it will add to the file instead of overwrite it
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new XMLFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getAllConsoleHandler();
        logger.setLevel(Level.INFO);

        logger.setFilter(createFilterWord("message"));
        logger.log(Level.INFO,"This is an info message");
        logger.log(Level.WARNING,"This is a warning message Hello");
        logger.log(Level.FINE,"This is a fine message"); //log manager sets up certain default and decides the level that is printed
    }

    private static void getAllConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomFormatter());
        consoleHandler.setLevel(Level.ALL);

        App.logger.setUseParentHandlers(false);
        App.logger.addHandler(consoleHandler);

    }

    public static CustomFilter createFilterWord(String word){
        return new CustomFilter(word);
    }

}
