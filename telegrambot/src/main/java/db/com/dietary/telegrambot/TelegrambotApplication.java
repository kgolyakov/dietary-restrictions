package telegrambotUI.src.main.java.db.com.dietary.telegrambot;
import db.Dietary.IngredientTelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import telegrambotUI.src.main.java.db.com.dietary.telegrambot.model.TelegramBot;


@SpringBootApplication
public class TelegrambotApplication {

    @Bean
    @Primary
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplateWithZul(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        SpringApplication.run(IngredientTelegramBot.class, args);
    }

}
