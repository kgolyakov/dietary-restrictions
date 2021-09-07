package db.com.dietary.telegrambot.model;

import db.Dietary.Ingredient.Ingredient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserIngredients {
    private List<Ingredient> entities = new ArrayList<Ingredient>();
    private String chatId;
    private Ingredient incorrectProduct;

    public UserIngredients(String chatId){
        this.chatId = chatId;
    }

    public void fixIngredient(Ingredient correctProduct){

        if (entities.contains(incorrectProduct)){
            int index = entities.indexOf(incorrectProduct);

            entities.set(index, correctProduct);
        }
    }
}
