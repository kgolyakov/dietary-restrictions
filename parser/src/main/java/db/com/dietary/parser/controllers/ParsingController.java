package db.com.dietary.parser.controllers;
import db.Dietary.Ingredient.Ingredient;
import db.com.dietary.parser.model.ParserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/parsing")
@RequiredArgsConstructor
public class ParsingController {
    @Autowired
    ParserManager parserManager;
    //@Autowired
    //AnalysisManager analysisManager;

    @PutMapping(value = "/sendImage")
    public List<Ingredient> sendImage(@RequestBody BufferedImage image){
        System.out.println("imageURL = " + image);
        List<Ingredient> ingredients = parserManager.getIngredientsFromImage(image);
        return ingredients; //analysisManager.analysis(ingredients);
    }
}