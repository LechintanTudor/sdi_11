package ro.ubbcluj.rabbit.client;

import org.springframework.web.client.RestTemplate;
import ro.ubbcluj.rabbit.client.console.ConsoleUi;

public class RabbitClient {
    public static void main(String[] args) {
        var rest = new RestTemplate();
        var consoleUi = new ConsoleUi(rest);
        consoleUi.run();
    }
}
