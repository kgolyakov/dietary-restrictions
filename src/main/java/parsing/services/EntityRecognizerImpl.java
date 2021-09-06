package parsing.services;

import java.util.ArrayList;
import java.util.List;

public class EntityRecognizerImpl implements EntityRecognizer {
    @Override
    public List<String> createEntities(String source) {
        return new ArrayList<String>(List.of(source.split(", ")));
    }
}
