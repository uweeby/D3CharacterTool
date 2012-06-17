import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ImageCapture {
	//Started to add separate captures for each text area.
	//realized doing it all at once is a better idea.
	//Have not verified base stats, armor, level work but they should.
	
	//Init:
	double screenWidth;
	double screenHeight;
	
	//Capture Details portion of character screen
	public BufferedImage CaptureDetails() throws AWTException{
		BufferedImage screencapture = new Robot().createScreenCapture(
			new Rectangle(1250, 110, 75, 680)); //Set for 1080p
		
		return screencapture;
	}
	
	//Capture Base Stats portion of character screen
	public BufferedImage CaptureBaseStats() throws AWTException{
		BufferedImage screencapture = new Robot().createScreenCapture(
				new Rectangle(1535, 215, 60, 130)); //Set for 1080p
		
		return screencapture;
	}
	
	//Capture Armor and Damage portion of character screen
	public BufferedImage CaptureArmorDamage() throws AWTException{
		BufferedImage screencapture = new Robot().createScreenCapture(
				new Rectangle(1515, 375, 80, 60)); //Set for 1080p
		
		return screencapture;
	}
	
	//Capture Character Level portion of character screen
	public BufferedImage CaptureCharacterLevel() throws AWTException{
		BufferedImage screencapture = new Robot().createScreenCapture(
				new Rectangle(1835, 175, 25, 25)); //Set for 1080p
		
		return screencapture;
	}
	
	//Find Display Resolution
	public void FindResolution() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.getWidth();
		screenHeight = screenSize.getHeight();
	}
}

