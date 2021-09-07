//package db.Dietary;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.telegram.telegrambots.meta.TelegramBotsApi;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
//import telegrambotUI.src.main.java.db.com.dietary.telegrambot.model.TelegramBot;
//
//
////@SpringBootApplication
//
//@EnableScheduling
////@SneakyThrows
//@SpringBootApplication
//public class IngredientTelegramBot {
//    public static void main(String[] args) {
//       // TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//
//// When using webhook, create your own version of DefaultWebhook with all your parameters set.
//       // TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class, defaultWebhookInstance);
//        try {
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            botsApi.registerBot(new TelegramBot());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//        SpringApplication.run(IngredientTelegramBot.class, args);
//
//    }
//}
