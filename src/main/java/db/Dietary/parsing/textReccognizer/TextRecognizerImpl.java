package db.Dietary.parsing.textReccognizer;

import db.Dietary.parsing.textReccognizer.TextRecognizer;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class TextRecognizerImpl implements TextRecognizer {
    @Override
    public String recognize(BufferedImage source) {
        return "Кофе, мясо говядина";
    }
}
