package db.Dietary.parsing;

import db.Dietary.analysing.AnalysisManager;
import db.Dietary.parsing.services.EntityRecognizer;
import db.Dietary.parsing.services.EntityRecognizerImpl;
import db.Dietary.parsing.services.TextRecognizer;
import db.Dietary.parsing.services.TextRecognizerImpl;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class ParserManager {
    private EntityRecognizer entityRecognizer = new EntityRecognizerImpl();
    private TextRecognizer textRecognizer = new TextRecognizerImpl();
    private AnalysisManager analysisManager = new AnalysisManager();

    public Map<String, List<String>> analyseImage(BufferedImage input) {
        String recognize = textRecognizer.recognize(input);
        List<String> entities = entityRecognizer.createEntities(recognize);
        Map<String, List<String>> analysis = analysisManager.analysis(entities);
        return analysis;
    }
}
