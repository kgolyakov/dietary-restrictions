import parsing.ParserManager;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ParserManager parserManager = new ParserManager();
        Map<String, List<String>> strings = parserManager.analyseImage(new BufferedImage(100, 200, 5));
        System.out.println(strings);
    }
}
