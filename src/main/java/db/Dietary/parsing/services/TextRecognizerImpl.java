package db.Dietary.parsing.services;

import java.awt.image.BufferedImage;

public class TextRecognizerImpl implements TextRecognizer {
    @Override
    public String recognize(BufferedImage source) {
        return "Кофе, мясо говядина";
    }
}
