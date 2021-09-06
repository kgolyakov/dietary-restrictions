package analysing.services;

import dao.IngredientDAO;
import model.Restriction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyserImpl implements Analyser {
    @Autowired
    IngredientDAO ingredientDAO;

    @Override
    public Map<String, List<String>> getDietaryRestrictions(List<String> ingredients) {
        Map<String, List<String>> map = new HashMap<>();
        for (String ingredient : ingredients) {
            map.put(ingredient, ingredientDAO.getRestrictions(ingredientDAO.getIngredient(ingredient))
                            .stream()
                            .map(Restriction::getName)
                            .collect(Collectors.toList()));
        }
        return map;
    }
}
