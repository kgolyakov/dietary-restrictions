package parsing;

import analysing.AnalysisManager;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import parsing.services.EntityRecognizer;
import parsing.services.EntityRecognizerImpl;
import parsing.services.TextRecognizer;
import parsing.services.TextRecognizerImpl;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class ParserManager {
    private EntityRecognizer entityRecognizer = new EntityRecognizerImpl();
    private TextRecognizer textRecognizer = new TextRecognizerImpl();
    private AnalysisManager analysisManager = new AnalysisManager();

    public Map<String, List<String>> analyseImage(TelegramBot bot, long chatId, BufferedImage input) {
        String recognize = textRecognizer.recognize(input);
        System.out.println("DBG recognized text:" + recognize);
        bot.execute(new SendMessage(chatId, "Recognized text:" + recognize));
        List<String> entities = entityRecognizer.createEntities(recognize);
        Map<String, List<String>> analysis = analysisManager.analysis(entities);
        return analysis;
    }
}
