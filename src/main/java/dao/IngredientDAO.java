package dao;

import model.Ingredient;

public interface IngredientDAO {
    Ingredient getIngredient(String name);
}
