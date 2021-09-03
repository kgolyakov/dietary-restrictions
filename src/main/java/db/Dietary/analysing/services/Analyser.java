package db.Dietary.analysing.services;

import java.util.List;
import java.util.Map;

public interface Analyser {
    public Map<String, List<String>> getDietaryRestrictions(List<String> ingredients);
}
