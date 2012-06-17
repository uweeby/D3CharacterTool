import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageScale {
	
	//Take in buffered image, scaled width, scaled height, t/f to preserve Alpha
	public BufferedImage createResizedCopy(
			Image originalImage, 
			int scaledWidth, 
			int scaledHeight, 
			boolean preserveAlpha) {
		
		int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
		Graphics2D g = scaledBI.createGraphics();
		
		if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
		}
		
		g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
		g.dispose();
		
		//return newly scaled up/down buffered image
		return scaledBI;
	}
}
