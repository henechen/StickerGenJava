import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickerGen {

    public void stickerGenerator(InputStream inputStream, String fileName) throws IOException {
        /*
         * Image reader
         */
//        InputStream inputStream = new FileInputStream("entrada/filme.jpg");
//        InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);

        /*
         * Create new image in memory with transparency and new size
         * NOTE: Removed the ability to add transparency and new size
         * because I'll place some new image (little sticker) instead of
         * adding and actual text
         */
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        /*
         * Copy of the original to the new image (in memory)
         */
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        /*
         * Writes a text on the image
         */
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.green);
        graphics.setFont(font);
        graphics.drawString("TOPZERA KEKW", 0, newHeight - 150);

        /*
         * Writes on the new image in a file
         */
        ImageIO.write(newImage, "png", new File(fileName));
    }
}
