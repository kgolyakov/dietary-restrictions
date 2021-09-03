package parsing.services;

import java.util.List;

public class EntityRecognizerImpl implements EntityRecognizer {
    @Override
    public List<String> createEntities(String source) {
        return List.of(source.split(", "));
    }
}
