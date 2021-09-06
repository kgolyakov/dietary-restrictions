import com.pengrad.telegrambot.TelegramBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import parsing.ParserManager;


public class Main {
    public static void main(String[] args) {
        /*TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        TelegramBot bot = new TelegramBot("1973421485:AAHuiDhX63Z42vAxsLTd2WR3N4V3LQftjL4");
        ParserManager parserManager = new ParserManager();
        System.out.println("Hello");
        bot.setUpdatesListener(updates -> {
            return processUpdate(bot, parserManager, updates);
        });*/
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new telegrambotUI.TelegramBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}
