import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.List;

public class PdfReaderApplication {

    public static void main(String[] args) {

        PDFDocument pdf = new PDFDocument();
        try {
            pdf.load(new File("dummy.pdf"));

            final SimpleRenderer renderer = new SimpleRenderer();
            renderer.setResolution(300);

            final List<Image> images = renderer.render(pdf);

            final Image image = images.get(0);

            ImageIO.write((RenderedImage) image, "png", new File("dummy.png"));

            final int x = 1;






        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
