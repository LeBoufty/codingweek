package eu.telecomnancy.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageBlob {

    public static byte[] imageViewToBytes(ImageView imageView) throws IOException {
        // Récupérer l'image depuis l'ImageView
        Image image = imageView.getImage();

        // Obtenir le PixelReader de l'image
        PixelReader pixelReader = image.getPixelReader();

        // Largeur et hauteur de l'image
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        // Convertir les données d'image en byte[]
        return imageToBytes(pixelReader, width, height);
    }

    private static byte[] imageToBytes(PixelReader pixelReader, int width, int height) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            // Écrire les données d'image dans le tableau de bytes
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Récupérer la couleur du pixel
                    Color color = pixelReader.getColor(x, y);

                    // Convertir la couleur en valeurs RGB (8 bits par canal)
                    int red = (int) (color.getRed() * 255);
                    int green = (int) (color.getGreen() * 255);
                    int blue = (int) (color.getBlue() * 255);

                    // Écrire les valeurs RGB dans le tableau de bytes
                    baos.write(red);
                    baos.write(green);
                    baos.write(blue);
                }
            }

            return baos.toByteArray();
        }
    }
}
