package eu.telecomnancy.Model;

import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageBlob {

    public static byte[] pathtToByte(String path) throws Exception{
        File imageFile = new File(path);
        byte[] imageData = Files.readAllBytes(imageFile.toPath());
        return imageData;
    }

    public static byte[] imageToByte(Image image) throws Exception{
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
        byte[] imageData = pathtToByte("/tmp/potehgist.png");
        
        return imageData;
    }

    public static byte[] imageViewToBytes(ImageView imageView) throws Exception {
        // Récupérer l'image depuis l'ImageView
        Image image = imageView.getImage();

            // Convertir l'image en byte[]
        byte[] imageData = imageToByte(image);
            
        return imageData;
    }
}
