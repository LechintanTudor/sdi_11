package ro.ubbcluj.rabbit;

import org.springframework.web.client.RestTemplate;
import ro.ubbcluj.rabbit.web.dto.RabbitDto;

public class RabbitClient {
    public static void main(String[] args) {
        var rest = new RestTemplate();
        var rabbits = rest.getForObject("http://localhost:8080/api/rabbits", RabbitDto.class);
        System.out.println(rabbits);
    }
}
