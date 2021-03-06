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
		
		description_text.setLineWrap(true);
		
		this.add(panel);
		ok_button.addActionListener(this);
		
		this.setTitle("Class information");
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		if(string == "Warrior" ){
			description_text.setText("The Warrior focuses on melee combat, and uses a special resource known as Fury that builds up during fights for special attacks. The Warrior"
					+ " is also quite durable, though not as much as the Paladin. In addition, the Warrior is the only class that can dual-wield swords, axes and maces. ");
		}
		if(string == "Paladin"){
			description_text.setText("The Paladin is a melee combat class who uses a shield as well as heavy armor to defend himself. Because of this, he is the most durable"
					+ " class in the game, even if his damage output is not the highest. He has special abilities, allowing him to do more damage or heal easier.");
		}
		if(string == "Mage"){
			description_text.setText("The Mage is a ranged class that uses powerful magic spells to inflict damage. He also has basic healing abilities if the situation needs it. "
					+ "However, he's not very well-protected and not as tough as the Warrior or Paladin.");
		}
		if(string == "Rogue"){
			description_text.setText("The Rogue is an assassin who easily avoids enemy attacks, though is in serious trouble if they hit. However, he easily does some major damage and"
					+ " can use poisons to, for example, do damage over time or paralyze the enemy.");
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok_button){
			this.dispose();
			}
		
	}

}
