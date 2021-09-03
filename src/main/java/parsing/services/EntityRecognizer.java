package parsing.services;

import java.util.List;

public interface EntityRecognizer {
    public List<String> createEntities(String source);
}
