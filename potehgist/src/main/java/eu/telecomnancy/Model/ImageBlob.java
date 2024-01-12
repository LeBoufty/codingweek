package eu.telecomnancy.Model;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.nio.file.Files;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import javafx.embed.swing.SwingFXUtils;

public class ImageBlob {

    public static byte[] pathtToByte(String path) throws Exception{
        File imageFile = new File(path);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imageFile));
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            return bos.toByteArray();
        }
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
