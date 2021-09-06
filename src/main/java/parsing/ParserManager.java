package parsing;

import analysing.AnalysisManager;
import lombok.SneakyThrows;
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

    @SneakyThrows
    public Map<String, List<String>> analyseImage(telegrambotUI.TelegramBot bot, String chatId, BufferedImage input) {
        String recognize = textRecognizer.recognize(input);
        List<String> entities = entityRecognizer.createEntities(recognize);
        bot.execute(bot.sendInlineKeyBoardMessage(chatId, entities));
        Map<String, List<String>> analysis = analysisManager.analysis(entities);
        return analysis;
    }
}
