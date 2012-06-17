import java.awt.AWTException;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class D3CharTool {
	public static void main(String[] args) throws AWTException{
		//GUI Setup
		GUI guiObject = new GUI();
		guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiObject.setSize(500,600);
		guiObject.setVisible(true);
		
	}
	
	public static String[] startCapture() {
		String[] textAreaArray = new String[33];
		try {
    		//When key is pressed take screen shot
			ImageCapture imagecapture = new ImageCapture();
			BufferedImage imageholder = imagecapture.CaptureDetails();
				
			//Invert screen shot as white font cannot be used by the OCR
			ImageInvert imageinvert = new ImageInvert(); 
			imageholder = imageinvert.Invert(imageholder);
			
			//Scale up for better readability
			ImageScale imagescale = new ImageScale();
			imageholder = imagescale.createResizedCopy(imageholder,  imageholder.getWidth() * 2, imageholder.getHeight() * 2, true);
			
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
}
