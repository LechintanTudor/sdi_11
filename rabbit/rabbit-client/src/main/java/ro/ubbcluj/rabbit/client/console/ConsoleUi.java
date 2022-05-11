package ro.ubbcluj.rabbit.client.console;

import org.springframework.web.client.RestTemplate;
import ro.ubbcluj.rabbit.client.console.exception.InvalidArgumentCountException;
import ro.ubbcluj.rabbit.web.dto.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;

public class ConsoleUi {
    private static void validateArgumentCount(String[] args, int expected) {
        if (args.length != expected) {
            throw new InvalidArgumentCountException(args.length, expected);
        }
    }

    boolean isRunning;
    private final TreeMap<String, Command> commands;
    private final RestTemplate rest;

    public ConsoleUi(RestTemplate rest) {
        this.rest = rest;
        isRunning = true;

        commands = new TreeMap<>();

        // Navigation
        addCommand("exit", this::exit, "");
        addCommand("help", this::showHelp, "");

        // Rabbit
        addCommand("saveRabbit", this::saveRabbit, "username");
        addCommand("findAllRabbits", this::findAllRabbits, "");
        addCommand("updateRabbit", this::updateRabbit, "id, username");
        addCommand("deleteRabbitById", this::deleteRabbitById, "id");

        // Rabbit holes
        addCommand("saveRabbitHole", this::saveRabbitHole, "name");
        addCommand("findAllRabbitHoles", this::findAllRabbitHoles, "");
        addCommand("updateRabbitHole", this::updateRabbitHole, "id, name");
        addCommand("deleteRabbitHoleById", this::deleteRabbitHoleById, "id");

        // Subscriptions
        addCommand("saveSubscription", this::saveSubscription, "rabbitId, rabbitHoleId");
        addCommand("findAllSubscriptions", this::findAllSubscriptions, "");
        addCommand("deleteSubscription", this::deleteSubscription, "rabbitId, rabbitHoleId");
    }

    private void addCommand(String commandName, Consumer<String[]> command, String commandParams) {
        commands.put(commandName, new Command(command, commandParams));
    }

    private void exit(String[] args) {
        validateArgumentCount(args, 0);
        System.exit(0);
    }

    private void showHelp(String[] args) {
        validateArgumentCount(args, 0);

        System.out.println("[COMMANDS]");
        for (var pair : commands.entrySet()) {
            System.out.printf("* %s(%s)\n", pair.getKey(), pair.getValue().getDescription());
        }
    }

    private String url(String route) {
        return String.format("http://localhost:8080/api%s", route);
    }

    private void saveRabbit(String[] args) {
        validateArgumentCount(args, 1);
        var username = args[0];

        rest.postForObject(url("/rabbits"), new RabbitDto(null, username), RabbitDto.class);
    }

    private void findAllRabbits(String[] args) {
        validateArgumentCount(args, 0);

        var rabbitsDto = rest.getForObject(url("/rabbits"), RabbitsDto.class);
        rabbitsDto.rabbits().forEach(System.out::println);
    }

    private void updateRabbit(String[] args) {
        validateArgumentCount(args, 2);
        var id = Long.parseLong(args[0]);
        var username = args[1];

        rest.put(url("/rabbits"), new RabbitDto(id, username));
    }

    private void deleteRabbitById(String[] args) {
        validateArgumentCount(args, 1);
        var id = Long.parseLong(args[0]);

        rest.delete(url(String.format("/rabbits/%d", id)));
    }

    private void saveRabbitHole(String[] args) {
        validateArgumentCount(args, 1);
        var name = args[0];

        rest.postForObject(url("/rabbit-holes"), new RabbitHoleDto(null, name), RabbitHoleDto.class);
    }

    private void findAllRabbitHoles(String[] args) {
        validateArgumentCount(args, 0);

        var rabbitHoles = rest.getForObject(url("/rabbit-holes"), RabbitHolesDto.class);
        rabbitHoles.rabbitHoles().forEach(System.out::println);
    }

    private void updateRabbitHole(String[] args) {
        validateArgumentCount(args, 2);
        var id = Long.parseLong(args[0]);
        var name = args[1];

        rest.put(url("/rabbit-holes"), new RabbitDto(id, name));
    }

    private void deleteRabbitHoleById(String[] args) {
        validateArgumentCount(args, 1);
        var id = Long.parseLong(args[0]);

        rest.delete(url(String.format("/rabbit-holes/%d", id)));
    }

    private void saveSubscription(String[] args) {
        validateArgumentCount(args, 2);
        var rabbitId = Long.parseLong(args[0]);
        var rabbitHoleId = Long.parseLong(args[1]);

        rest.postForObject(url("/subscriptions"), new SubscriptionDto(rabbitId, rabbitHoleId), SubscriptionDto.class);
    }

    private void findAllSubscriptions(String[] args) {
        validateArgumentCount(args, 0);

        var subscriptions = rest.getForObject(url("/subscriptions"), SubscriptionsDto.class);
        subscriptions.subscriptions().forEach(System.out::println);
    }

    private void deleteSubscription(String[] args) {
        validateArgumentCount(args, 2);
        var rabbitId = Long.parseLong(args[0]);
        var rabbitHoleId = Long.parseLong(args[1]);

        rest.delete(url(String.format("/subscriptions/%d/%d", rabbitId, rabbitHoleId)));
    }

    public void run() {
        var scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.print(">>> ");

            var fullCommand = scanner.nextLine().split("\\s+");
            var commandName = fullCommand[0];
            var args = Arrays.copyOfRange(fullCommand, 1, fullCommand.length);

            var command = commands.get(commandName);
            if (command == null) {
                System.out.printf("[ERROR]: Invalid command `%s`\n\n", commandName);
                continue;
            }

            try {
                command.execute(args);
            } catch (Exception error) {
                System.out.printf("[ERROR]: %s\n\n", error.getMessage());
                continue;
            }

            System.out.println();
        }
    }
}
