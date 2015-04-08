import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class mainGameWindow extends JFrame implements ActionListener {
	
	JPanel mainPanel, emptyPanel1, emptyPanel2;
	JButton startButton, continueButton;
	JButton[] character_info_button = new JButton[4];
	JButton[] character_select_button = new JButton[4];
	JTextArea introductionText, questInfo;
	JLabel healthLabel, resourceLabel;
	static mainGameWindow gamewindow;
	GridBagConstraints c = new GridBagConstraints(); //Anv�nds senare f�r GridBagLayout
	Player playercharacter;

	public mainGameWindow() {
		mainPanel = new JPanel();
		emptyPanel1 = new JPanel(); //Dessa paneler finns enbart f�r att centrera den tredje
		emptyPanel2 = new JPanel();
		startButton = new JButton("Start Game");
		introductionText = new JTextArea();
		continueButton = new JButton("Continue");
		
		for(int i = 0; i<4; i++){
			character_info_button[i] = new JButton("Information");
			character_select_button[i] = new JButton("Choose Class");
			character_info_button[i].addActionListener(this);
			character_select_button[i].addActionListener(this);
		}
		
		startButton.addActionListener(this);
		continueButton.addActionListener(this);
		
		this.setSize(1280,720);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("UNTITLED GAME");
	}

	public static void main(String[] args) {
		gamewindow = new mainGameWindow();
		gamewindow.setWindowType("main_menu", gamewindow);

	}


	private void setWindowType(String string, mainGameWindow window) { //Metod som �ndrar om f�nstret
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
			c.ipady = 600;  //Alla dessa kommandon �r f�r att f� layouten att se "r�tt" ut s� att knappen och textrutan har r�tt storlek.
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
		
		if(string == "character_select"){
			mainPanel.removeAll();
			mainPanel.setLayout(new GridLayout(1,4));
			JLabel[] character_labels = new JLabel[4];
			JLabel[] character_labels_img = new JLabel[4];
			JPanel[] character_panels = new JPanel[4];
			JPanel[] character_button_panels = new JPanel[4];
			
			
			
			for(int i = 0; i<4; i++){
				character_panels[i] = new JPanel();
				character_panels[i].setLayout(new GridLayout(3,1));
				character_labels[i] = new JLabel();
				character_labels_img[i] = new JLabel();
				character_button_panels[i] = new JPanel();
				character_button_panels[i].setLayout(new GridLayout(1,2));
				character_button_panels[i].add(character_info_button[i]);
				character_button_panels[i].add(character_select_button[i]);
				
				
				
			}
			character_labels[0].setText("Warrior");
			character_labels[1].setText("Paladin");
			character_labels[2].setText("Mage");
			character_labels[3].setText("Rogue");
			
			character_labels_img[0].setText("Warrior image placeholder");
			character_labels_img[1].setText("Paladin image placeholder");
			character_labels_img[2].setText("Mage image placeholder");
			character_labels_img[3].setText("Rogue image placeholder");
			
			for(int i = 0; i<4; i++){
				character_panels[i].add(character_labels[i]);
				character_panels[i].add(character_labels_img[i]);
				character_panels[i].add(character_button_panels[i]);
				mainPanel.add(character_panels[i]);
			
			}
			
			validate();
			repaint();
		}
		
		if(string == "gameplay"){
			mainPanel.removeAll();
			mainPanel.setLayout(new GridBagLayout());
			
			
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
		
		if(e.getSource() == character_info_button[0]){
			new ClassInfo("Warrior");
		}
		
		if(e.getSource() == character_info_button[1]){
			new ClassInfo("Paladin");
		}
		if(e.getSource() == character_info_button[2]){
			new ClassInfo("Mage");
		}
		if(e.getSource() == character_info_button[3]){
			new ClassInfo("Rogue");
		}
		
		if(e.getSource() == character_select_button[0]){
			playercharacter.setClass("Warrior");
			gamewindow.setWindowType("gameplay", gamewindow);
			
		}
		
		if(e.getSource() == character_select_button[1]){
			//playercharacter.setClass("Paladin");
		}
		
		if(e.getSource() == character_select_button[2]){
			//playercharacter.setClass("Mage");
		}
		
		if(e.getSource() == character_select_button[3]){
			//playercharacter.setClass("Rogue");
		}
	}

}
