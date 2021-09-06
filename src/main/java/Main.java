import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import parsing.ParserManager;
import telegrambotUI.TelegramBot;


public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        /*TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        TelegramBot bot = new TelegramBot("1973421485:AAHuiDhX63Z42vAxsLTd2WR3N4V3LQftjL4");
        ParserManager parserManager = new ParserManager();
        System.out.println("Hello");
        bot.setUpdatesListener(updates -> {
            return processUpdate(bot, parserManager, updates);
        });*/
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
