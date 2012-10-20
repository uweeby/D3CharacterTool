import java.awt.image.BufferedImage;  
import java.util.ArrayList; 
import java.util.HashMap; 
import net.sourceforge.javaocr.gui.GUIController; 
import net.sourceforge.javaocr.gui.meanSquareOCR.TrainingImageSpec; 
import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange; 
import net.sourceforge.javaocr.ocrPlugins.mseOCR.OCRScanner; 
import net.sourceforge.javaocr.ocrPlugins.mseOCR.TrainingImage;  

public class JavaOCR {
	
	//Declare Variables
	String[] tempArray = new String[28]; 
	
	public String[] startOCR(BufferedImage input) {
		//Take in buffered image to run OCR
		BufferedImage targetImage = input;
		
		// Load 4 training files 
		ArrayList<TrainingImageSpec> images = new ArrayList<TrainingImageSpec>(0); 
		TrainingImageSpec tis = null;
		
		//Special Characters: (Row 1 from ASCII Shuffled)
		tis = new TrainingImageSpec();
		tis.setFileLocation("src/D3-Percent-Dash-Font.png"); 
		tis.setCharRange(new CharacterRange('%', '-'));
		images.add(tis);
		
		//Numbers and Period: (Row 2 from ASCII Shuffled)
		tis = new TrainingImageSpec();
		tis.setFileLocation("src/D3-0-9-Font.png"); 
		tis.setCharRange(new CharacterRange('.', '9'));
		images.add(tis);
		
		//Did not want to read the number 8 correctly this fixes that
		tis = new TrainingImageSpec();
		tis.setFileLocation("src/D3-8-Actual.png"); 
		tis.setCharRange(new CharacterRange('8'));
		images.add(tis);
		
		// Run the OCR on our screen shot
		OCRScanner ocrScanner = new OCRScanner();
		
		try  {
			HashMap<Character, ArrayList<TrainingImage>> trainingImages = 
			GUIController.getTrainingImageHashMap(images); 
			ocrScanner.addTrainingImages(trainingImages);  
			
			// test image 1 
			String text = ocrScanner.scan(targetImage, 0, 0, 0, 0, null);
			text = text.trim().replaceAll(" +", ""); //Bug?? Sometimes spaces show up around % signs
			
			//Split by new line into String array
			tempArray = text.split("\n");
			
			} catch (Exception e)  {
				e.printStackTrace();
			}
		
		return tempArray;
		} 
	}