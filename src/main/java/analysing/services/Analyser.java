package analysing.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface Analyser {
    public Map<String, List<String>> getDietaryRestrictions(List<String> ingredients);
}
