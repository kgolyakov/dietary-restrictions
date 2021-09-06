package db.Dietary.parsing;

import db.Dietary.Ingredient.Ingredient;
import db.Dietary.analysing.AnalysisManager;
import db.Dietary.parsing.entityRecognizer.EntityRecognizer;
import db.Dietary.parsing.entityRecognizer.EntityRecognizerImpl;
import db.Dietary.parsing.textReccognizer.TextRecognizer;
import db.Dietary.parsing.textReccognizer.TextRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

@Service
public class ParserManagerImpl implements ParserManager{
    @Autowired
    private EntityRecognizer entityRecognizer;
    @Autowired
    private TextRecognizer textRecognizer;
//    @Autowired
//    private AnalysisManager analysisManager;

    public List<Ingredient> getIngredientsFromImage (BufferedImage input) {
        return  entityRecognizer.createEntities(textRecognizer.recognize(input));
    }
}
