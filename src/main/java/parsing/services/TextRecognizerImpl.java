package parsing.services;

import lombok.SneakyThrows;
import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextRecognizerImpl implements TextRecognizer {
    @Override
    @SneakyThrows
    public String recognize(BufferedImage source) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\Xiaomi\\JavaSchoolDB\\tessdata");
        tesseract.setLanguage("rus");
        System.out.println("Imported tessdata");
        File file = new File("downloaded.jpg");

        // jpg needs BufferedImage.TYPE_INT_RGB
        // png needs BufferedImage.TYPE_INT_ARGB

        // create a blank, RGB, same width and height
        BufferedImage newBufferedImage = new BufferedImage(
                source.getWidth(),
                source.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // draw a white background and puts the originalImage on it.
        newBufferedImage.createGraphics()
                .drawImage(source,
                        0,
                        0,
                        Color.WHITE,
                        null);

        // save an image

        ImageIO.write(newBufferedImage, "jpg", file);
        return tesseract.doOCR(file);
    }
}
