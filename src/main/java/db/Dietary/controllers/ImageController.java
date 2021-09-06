package db.Dietary.controllers;

import db.Dietary.Ingredient.Ingredient;
import db.Dietary.analysing.AnalysisManager;
import db.Dietary.parsing.ParserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

@RestController
public class ImageController {

    @Autowired
    ParserManager parserManager;
    @Autowired
    AnalysisManager analysisManager;


    @PutMapping(value = "/sendImage")
    public Map<String, List<String>> sendImage(@RequestBody BufferedImage image){
        System.out.println("imageURL = " + image);
        List<Ingredient> ingredients = parserManager.getIngredientsFromImage(image);
        return analysisManager.analysis(ingredients);
    }

}
