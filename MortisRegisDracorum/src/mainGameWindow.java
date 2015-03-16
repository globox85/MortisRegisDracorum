import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class mainGameWindow extends JFrame implements ActionListener {
	
	JPanel mainPanel, emptyPanel1, emptyPanel2;
	JButton startButton, continueButton;
	JTextArea introductionText;
	static mainGameWindow gamewindow;
	static boolean startPressed = false;
	GridBagConstraints c = new GridBagConstraints();

	public mainGameWindow() {
		mainPanel = new JPanel();
		emptyPanel1 = new JPanel();
		emptyPanel2 = new JPanel();
		startButton = new JButton("Start Game");
		introductionText = new JTextArea();
		continueButton = new JButton("Continue");
		
		startButton.addActionListener(this);
		continueButton.addActionListener(this);
		
		this.setSize(1280,720);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mortis Regis Dracorum");
	}

	public static void main(String[] args) {
		gamewindow = new mainGameWindow();
		gamewindow.setWindowType("main_menu", gamewindow);

	}


	private void setWindowType(String string, mainGameWindow window) {
		if(string == "main_menu"){
			mainPanel.setLayout(new GridLayout(1,3));
			mainPanel.add(emptyPanel1);
			mainPanel.add(startButton);
			mainPanel.add(emptyPanel2);
			window.add(mainPanel);
		}
		if(string == "introduction"){
			introductionText.setText("Greetings, adventurer! The greatest quest of your life is"
					+ " about to begin. After a thousand years of slumber, Nal'tharion, the "
					+ "devourer of worlds has risen once more. In their darkest hour, the people of"
					+ " Falconkeep call out for aid. \nThe very next day, a young traveller arrives...  ");
			mainPanel.removeAll();
			mainPanel.setLayout(new GridBagLayout());
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			c.ipadx = 1200;
			c.ipady = 600;
			c.gridwidth = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			mainPanel.add(introductionText,c);
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 0;
			c.gridy = 1;
			c.ipadx = 400;
			c.ipady = 50;
			c.anchor = GridBagConstraints.PAGE_END;
			mainPanel.add(continueButton,c);
	
			validate();
			repaint();
			
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton){
			gamewindow.setWindowType("introduction", gamewindow);
		}
		if(e.getSource() == continueButton){
			gamewindow.setWindowType("character_select", gamewindow);
		}
		
	}

}
