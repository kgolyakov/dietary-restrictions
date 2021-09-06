package db.Dietary.parsing.entityRecognizer;

import db.Dietary.Ingredient.Ingredient;

import java.util.List;

public interface EntityRecognizer {
    public List<Ingredient> createEntities(String source);
}
