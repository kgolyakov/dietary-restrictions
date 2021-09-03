package parsing.services;

import lombok.SneakyThrows;
import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TextRecognizerImpl implements TextRecognizer {
    @Override
    @SneakyThrows
    public String recognize(BufferedImage source) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("D://tessdata");
        tesseract.setLanguage("rus");
        System.out.println("Imported tessdata");
        File file = new File("downloaded.jpg");
        ImageIO.write(source, "jpg", file);
        return tesseract.doOCR(file);
    }
}
