package db.com.dietary.parser.model.entityRecognizer;

import db.Dietary.Ingredient.Ingredient;
import db.Dietary.Ingredient.IngredientImp;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityRecognizerImpl implements EntityRecognizer {
    @Override
    public List<Ingredient> createEntities(String source) {
        return Arrays.stream(source.split(", ")).
                map(s -> new IngredientImp(s)).
                collect(Collectors.toList());
    }
}
