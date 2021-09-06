package analysing.services;

import dao.IngredientDAO;
import dao.UserDAO;
import model.Ingredient;
import model.Restriction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class PersonalizedAnalyserImpl implements PersonalizedAnalyser {

    @Autowired
    UserDAO userDAO;

    @Autowired
    IngredientDAO ingredientDAO;

    @Override
    public Map<String, List<String>> getDietaryRestrictions(List<String> ingredients, long chatId) {
        Set<Restriction> set = userDAO.getRestrictions(chatId);
        Map<String, List<String>> map = new HashMap<>();
        for (String ingredient : ingredients) {
            Ingredient ingredient1 = ingredientDAO.getIngredient(ingredient);
            Set<Restriction> restrictions = ingredientDAO.getRestrictions(ingredient1);
            List<String> collect = restrictions.stream().filter(set::contains).map(Restriction::getName).collect(Collectors.toList());
            map.put(ingredient, collect);
        }
        return map;
    }
}
