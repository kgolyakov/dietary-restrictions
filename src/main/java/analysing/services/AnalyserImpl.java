package analysing.services;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AnalyserImpl implements Analyser {
    @Override
    public Map<String, List<String>> getDietaryRestrictions(List<String> ingredients) {
        Map<String, List<String>> result = new HashMap<>();
        for (String ingredient : ingredients) {
            if (ingredient.toLowerCase(Locale.ROOT).contains("мясо")) {
                if (result.containsKey("Meat")) {
                    result.get("Meat").add(ingredient);
                } else {
                    result.put("Meat", List.of(ingredient));
                }
            }
            if (ingredient.toLowerCase(Locale.ROOT).contains("кофе")) {
                if (result.containsKey("Coffee")) {
                    result.get("Coffee").add(ingredient);
                } else {
                    result.put("Coffee", List.of(ingredient));
                }
            }
        }
        return result;
    }
}
