import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.List;

public class PdfReaderApplication {

    public static void main(String[] args) {

        final PDFDocument pdfDoc = new PDFDocument();
        final File pdfFile = new File("pdfs/gameRules.pdf");
        try {
            pdfDoc.load(pdfFile);

            final SimpleRenderer renderer = new SimpleRenderer();
            renderer.setResolution(30);

            final Image image = renderer.render(pdfDoc, 0, 0).get(0);

            final File file = new File("pngs/gameRules.png");

            ImageIO.write((RenderedImage) image, "png", file);

            final BufferedImage bufferedImage = ImageIO.read(file);
            final int rgb = bufferedImage.getRGB(0, 0);
            int  red   = (rgb & 0x00ff0000) >> 16;
            int  green = (rgb & 0x0000ff00) >> 8;
            int  blue  =  rgb & 0x000000ff;

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
