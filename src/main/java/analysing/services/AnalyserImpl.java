package analysing.services;

import java.util.*;

public class AnalyserImpl implements Analyser {
    @Override
    public Map<String, List<String>> getDietaryRestrictions(List<String> ingredients) {
        Map<String, List<String>> result = new HashMap<>();
        for (String ingredient : ingredients) {
            if (ingredient.toLowerCase(Locale.ROOT).contains("мясо")) {
                if (result.containsKey("Meat")) {
                    result.get("Meat").add(ingredient);
                } else {
                    result.put("Meat", new ArrayList<>(List.of(ingredient)));
                }
            }
            if (ingredient.toLowerCase(Locale.ROOT).contains("кофе")) {
                if (result.containsKey("Coffee")) {
                    result.get("Coffee").add(ingredient);
                } else {
                    result.put("Coffee", new ArrayList<>(List.of(ingredient)));
                }
            }
        }
        return result;
    }
}
