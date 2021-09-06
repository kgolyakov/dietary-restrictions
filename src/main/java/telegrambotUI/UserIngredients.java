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
        System.out.println(entities.toString());
        //System.out.println(incorrectProduct);
        if (entities.contains(incorrectProduct)){
            int index = entities.indexOf(incorrectProduct);
            System.out.println(index);
            //entities.set(index, correctProduct);
            List<String> temp = new ArrayList<String>(entities);
            temp.set(index, correctProduct);
            entities = temp;
        }
    }
}
