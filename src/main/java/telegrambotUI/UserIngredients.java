package telegrambotUI;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserIngredients {
    private List<String> entities = new ArrayList<String>();
    private String chatId;
    private String incorrectProduct;

    public UserIngredients(String chatId){
        this.chatId = chatId;
    }

    public void fixIngredient(String correctProduct){

        if (entities.contains(incorrectProduct)){
            int index = entities.indexOf(incorrectProduct);

            entities.set(index, correctProduct);
        }
    }
}
