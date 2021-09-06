package db.Dietary.parsing;

import db.Dietary.Ingredient.Ingredient;

import java.awt.image.BufferedImage;
import java.util.List;

public interface ParserManager {
    List<Ingredient> getIngredientsFromImage (BufferedImage input);
}
