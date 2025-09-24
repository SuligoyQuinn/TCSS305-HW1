package edu.uw.tcss.app;

import edu.uw.tcss.model.StoreItem;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A driver class for this application.
 *
 * @author Charles Bryan
 * @version Autumn 2024
 */
public final class StarterApplication {

    // TODO: read and complete all TODOs. Once completed, remove all TODO comments.

    // TODO: Right-click on this file -> Analyze -> Inspect Code : then clean up all warnings

    // TODO: In the file menu, View -> Tool Windows -> TODO

    /**
     * A Logger object for all your logging needs.
     * You should move away from using System.out.println as your logging/debugging method.
     */
    public static final Logger LOGGER = Logger.getLogger(StarterApplication.class.getName());

    static {
        // Level.ALL - Display ALL logging messages
        // Level.OFF - Display NO logging messages
        LOGGER.setLevel(Level.ALL);
    }

    private StarterApplication() {
        super();
    }

    /**
     * The entry point into this application.
     *
     * @param theArgs the command-line arguments for this program.
     */
    static void main(final String[] theArgs) {
        LOGGER.info("This is my first Computer Science course");
        LOGGER.info(() -> "I have been studying at UWT for two years, "
                + "this is where I took 142 and 143");
        LOGGER.info("David Schuessler was my professor for both of those classes");
    }

    /**
     * Checks if input string is equal to the string "BLUE".
     * @param theInput the string to be checked
     * @return true if input string is "BLUE", false otherwise
     */
    public static boolean isBlue(final String theInput) {
        return "BLUE".equalsIgnoreCase(theInput);
    }

}
