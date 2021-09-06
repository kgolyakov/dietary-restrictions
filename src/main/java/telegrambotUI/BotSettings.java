package telegrambotUI;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Document;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import lombok.SneakyThrows;
import parsing.ParserManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BotSettings {

/*

    @SneakyThrows
            public static int processUpdate(TelegramBot bot, ParserManager parserManager, List<Update> updates) {
        // ... process updates
        // return id of last processed update or confirm them all
        for(Update upd : updates) {
            System.out.println(upd.message().chat().id());
            long chatId = upd.message().chat().id();
            if(upd.message().document() != null) {
                Document document = upd.message().document();
                GetFile request = new GetFile(document.fileId());
                GetFileResponse getFileResponse = bot.execute(request);
                File file = getFileResponse.file();
                String fullPath = bot.getFullFilePath(file);
                System.out.println(fullPath);
                URL url = new URL(fullPath);
                BufferedImage img = ImageIO.read(url);
                bot.execute(new SendMessage(chatId, "Analyzing image..."));
//                Map<String, List<String>> strings = parserManager.analyseImage(this, chatId, img);
                bot.execute(new SendMessage(chatId, strings.toString()).replyMarkup(botButtons.setInline(List.of("чай", "кофе"))));
            }
            if(upd.callbackQuery() != null) {
                System.out.println(upd.callbackQuery());
            }

        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }*/
}
