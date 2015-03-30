import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class ClassInfo extends JFrame implements ActionListener {
	JButton ok_button;
	
	public ClassInfo(String string) {
		JPanel panel = new JPanel();
		ok_button = new JButton("OK");
		JTextArea description_text = new JTextArea();
		
		panel.setLayout(new GridLayout(2,1));
		panel.add(description_text);
		panel.add(ok_button);
		
		this.add(panel);
		ok_button.addActionListener(this);
		
		this.setTitle("Class information");
		this.setSize(200,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		if(string == "Warrior" ){
			description_text.setText("The Warrior focuses on melee combat, and uses a special resource known as Fury that builds up during fights for special attacks. The Warrior"
					+ "is also quite durable, though not as much as the Paladin. In addition, the Warrior is the only class that can dual-wield swords, axes and maces. ");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok_button){
			this.dispose();
			}
		
	}

}