package ro.ubbcluj.rabbit.client.console;

import ro.ubbcluj.rabbit.client.console.exception.InvalidArgumentCountException;

import java.util.function.Consumer;

/**
 * Command runnable from the Console UI.
 */
public class Command {
    /**
     * Validates that the command received the expected number of arguments.
     *
     * @param args             arguments received by the command.
     * @param expectedArgCount number of arguments expected by the command.
     */
    public static void validateArgCount(String[] args, int expectedArgCount) {
        if (args.length != expectedArgCount) {
            throw new InvalidArgumentCountException(args.length, expectedArgCount);
        }
    }

    final Consumer<String[]> command;
    final String description;

    /**
     * Build a command from a function and a description.
     *
     * @param command     command to run.
     * @param description command description.
     */
    public Command(Consumer<String[]> command, String description) {
        this.command = command;
        this.description = description;
    }

    /**
     * Returns the command description.
     *
     * @return command description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args arguments to pass to the command.
     */
    public void execute(String[] args) {
        command.accept(args);
    }
}
