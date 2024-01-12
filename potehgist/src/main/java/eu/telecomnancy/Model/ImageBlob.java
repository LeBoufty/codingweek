package eu.telecomnancy.Model;

import java.io.File;
import java.nio.file.Files;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;

public class ImageBlob {

    public static byte[] pathtToByte(String path) throws Exception{
        BufferedImage originalImage = ImageIO.read(new File(path));
        int newWidth = 500;
        int newHeight = 500;
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        
        AffineTransform transform = AffineTransform.getScaleInstance((double)newWidth / originalImage.getWidth(),
        (double)newHeight / originalImage.getHeight());
        g.drawRenderedImage(originalImage, transform);

        // Libérez les ressources graphiques
        g.dispose();

        // Spécifiez le chemin du fichier de sortie
        String outputFilePath = "/tmp/image_resized.png";

        // Écrivez l'image redimensionnée dans un nouveau fichier
        ImageIO.write(resizedImage, "png", new File(outputFilePath));


        byte[] imageData = Files.readAllBytes(new File(outputFilePath).toPath());
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
