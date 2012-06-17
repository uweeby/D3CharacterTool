import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageInvert {
	
    public BufferedImage Invert(BufferedImage imageName) {
    	//Take in a BuferedImage and invert the pixel data
        BufferedImage input = imageName;

        //Iterate through the whole image inverting the pixel values for RGB
        for (int x = 0; x < input.getWidth(); x++) {
            for (int y = 0; y < input.getHeight(); y++) {
                int rgba = input.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(),
                                255 - col.getGreen(),
                                255 - col.getBlue());
                input.setRGB(x, y, col.getRGB());
            }
        }
        
        //Return the newly inverted BufferedImage
		return input;
    }
}
