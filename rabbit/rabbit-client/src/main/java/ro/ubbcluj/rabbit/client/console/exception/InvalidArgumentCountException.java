package ro.ubbcluj.rabbit.client.console.exception;

/**
 * Exception thrown when a command receives an invalid number of arguments.
 */
public class InvalidArgumentCountException extends RuntimeException {
    /**
     * Constructs the exception.
     *
     * @param received the number of parameters the command received.
     * @param expected the number of parameters the command expected.
     */
    public InvalidArgumentCountException(int received, int expected) {
        super(String.format("Command expected %s arguments but received %s", expected, received));
    }
}