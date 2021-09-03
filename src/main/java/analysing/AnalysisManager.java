package analysing;

import analysing.services.Analyser;
import analysing.services.AnalyserImpl;

import java.util.List;
import java.util.Map;

public class AnalysisManager {
    private Analyser analyser = new AnalyserImpl();
    public Map<String, List<String>> analysis(List<String> input) {
        return analyser.getDietaryRestrictions(input);
    }
}
