package db.Dietary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
//@SneakyThrows
public class IngredientTelegromBot {
    public static void main(String[] args) {
       // TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

// When using webhook, create your own version of DefaultWebhook with all your parameters set.
       // TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class, defaultWebhookInstance);
        SpringApplication.run(IngredientTelegromBot.class, args);

    }
}
