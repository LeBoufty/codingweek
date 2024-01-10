package eu.telecomnancy.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import java.io.File;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.nio.file.Files;

public class ImageBlob {

    public static byte[] imageViewToBytes(ImageView imageView) throws IOException {
        // Récupérer l'image depuis l'ImageView
            Image image = imageView.getImage();

            java.awt.image.BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);

            // Save BufferedImage to file using ImageIO
            File outputFile = new File("/tmp/potehgist.png");
            ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
            ImageOutputStream outputStream = ImageIO.createImageOutputStream(outputFile);
            writer.setOutput(outputStream);
            writer.write(bufferedImage);
            outputStream.close();
            writer.dispose();

            // Récupérer le fichier
            File imageFile = new File("/tmp/potehgist.png");
            byte[] imageData = Files.readAllBytes(imageFile.toPath());
            
            return imageData;
    }
}
