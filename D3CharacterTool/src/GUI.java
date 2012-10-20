import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	//Declare Variables
	public String[] textAreaArray = new String[33];
	private JButton testbutton;
	public JTextArea field;
	
	public GUI() {
		//GUi Constructor
		super("D3 Character Tool"); //Window Title
		setLayout(new FlowLayout());
		
		testbutton = new JButton("Capture");
		testevent(testbutton);
		add(testbutton);
		
		field = new JTextArea();
		field.setBounds(5, 5, 100, 100);
		field.setPreferredSize(new Dimension(450,500));
	    add(field);
	}
	
	public void testevent(JButton button) {
		button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//JButton to activate capture
            	textAreaArray = ImageCapture.StartCapture();
            	
            	//Send the character information to the text area
            	for (int i = 0; i < textAreaArray.length; i++) {
            		field.append(textAreaArray[i]);
            	}
            }
        });
	}
}
