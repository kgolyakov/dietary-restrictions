package db.com.dietary.analyzer;

import db.Dietary.Ingredient.Ingredient;
import db.com.dietary.analyzer.services.Analyser;
import db.com.dietary.analyzer.services.AnalyserImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class AnalysisManager {
    private Analyser analyser = new AnalyserImpl();
    public Map<String, List<String>> analysis(List<Ingredient> input) {
        return analyser.getDietaryRestrictions(input.stream().map(Ingredient::getName).collect(Collectors.toList()));
    }
}
