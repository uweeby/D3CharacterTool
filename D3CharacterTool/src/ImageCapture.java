import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ImageCapture {
	//Currently only setup to work with 1080p resolution
	
	public static String[] StartCapture() {
		String[] textAreaArray = new String[33];
		try {
    		//When key is pressed take screen shot
			ImageCapture imagecapture = new ImageCapture();
			BufferedImage imageholder = imagecapture.CaptureDetails();
				
			//Invert screen shot as white font cannot be used by the OCR
			imageholder = OCRInvertImage(imageholder);
			
			//Scale up for better readability
			imageholder = OCRScaleImage(imageholder,  imageholder.getWidth() * 2, imageholder.getHeight() * 2, true);
			
			//Run OCR on screen shot
			JavaOCR javaocr = new JavaOCR();
			String[] temparray = javaocr.startOCR(imageholder);
			
			//Send array to Character Data to be converted to double
			CharacterData characterdata = new CharacterData();
			characterdata.DetailsWindow(temparray); //Add Details Window data from the OCR to Character Data
			
			//Debug print all character data to the console
			PrintCharacter printcharacter= new PrintCharacter();
			textAreaArray = printcharacter.setArray(characterdata);
	
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Returns a String array. Currently used for GUI display
		//Needs to be redone a better way
		return textAreaArray;
	}
	
    public static BufferedImage OCRInvertImage(BufferedImage imageName) {
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
    
	//Take in buffered image, scaled width, scaled height, t/f to preserve Alpha
	public static BufferedImage OCRScaleImage(
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
	
	/**
	 * Capture Details portion of character screen
	 */
	public BufferedImage CaptureDetails() throws AWTException {
		BufferedImage screencapture = new Robot().createScreenCapture(
			new Rectangle(1250, 110, 75, 680)); //Set for 1080p
		
		return screencapture;
	}
	
	/**
	 * Capture Base Stats portion of character screen
	 */
	public BufferedImage CaptureBaseStats() throws AWTException {
		BufferedImage screencapture = new Robot().createScreenCapture(
				new Rectangle(1535, 215, 60, 130)); //Set for 1080p
		
		return screencapture;
	}
	
	/**
	 * Capture Armor and Damage portion of character screen
	 */
	public BufferedImage CaptureArmorDamage() throws AWTException {
		BufferedImage screencapture = new Robot().createScreenCapture(
				new Rectangle(1515, 375, 80, 60)); //Set for 1080p
		
		return screencapture;
	}
	
	/**
	 * Capture Character Level portion of character screen
	 */
	public BufferedImage CaptureCharacterLevel() throws AWTException {
		BufferedImage screencapture = new Robot().createScreenCapture(
				new Rectangle(1835, 175, 25, 25)); //Set for 1080p
		
		return screencapture;
	}
}

