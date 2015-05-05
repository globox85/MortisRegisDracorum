import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class battleWindow extends JFrame implements ActionListener {
	JPanel mainPanel, buttonsPanel, statusPanel, combatPanel, playerStatusPanel, monsterStatusPanel;
	JButton attackButton, itemsButton, escapeButton;
	JLabel playerHealth, playerResource, monsterHealth, turnCounter;
	JTextArea combatStatus;
	int monsterNumber, playerTurns;
	Player player;
	
	Monster monster;
	public battleWindow(String battleType, Player playercharacter){
		monster = new Monster();
		player = playercharacter;
		mainPanel = new JPanel();
		buttonsPanel = new JPanel();
		statusPanel = new JPanel();
		combatPanel = new JPanel();
		playerStatusPanel = new JPanel();
		monsterStatusPanel = new JPanel();
		
		combatStatus = new JTextArea();
		
		attackButton = new JButton("Attack");
		itemsButton = new JButton("Items");
		escapeButton = new JButton("Escape");
		
		playerHealth = new JLabel("HP: " + playercharacter.health);
		playerResource = new JLabel();
		
		if(playercharacter.player_class == "Warrior"){
			playerResource.setText("Fury: " + playercharacter.fury);
		}
		
		if(battleType == "demo"){
			monsterNumber = 1;
			
			monster.setMonsterType("zombie");
		}
		
		mainPanel.setLayout(new GridLayout(3,1));
		buttonsPanel.setLayout(new GridLayout(1,3));
		statusPanel.setLayout(new GridLayout(1,3));
		combatPanel.setLayout(new GridLayout(1,monsterNumber));
		
		playerStatusPanel.setLayout(new GridLayout(2,1));
		playerStatusPanel.add(playerHealth);
		playerStatusPanel.add(playerResource);

		attackButton.addActionListener(this);
		itemsButton.addActionListener(this);
		escapeButton.addActionListener(this);
		
		statusPanel.add(playerStatusPanel);
		statusPanel.add(combatStatus);
		statusPanel.add(monsterStatusPanel);
		
		buttonsPanel.add(attackButton);
		buttonsPanel.add(itemsButton);
		buttonsPanel.add(escapeButton);
		
		mainPanel.add(statusPanel);
		mainPanel.add(combatPanel);
		mainPanel.add(buttonsPanel);
		
		this.add(mainPanel);
		
		this.setSize(640, 360);
		this.setVisible(true);
		this.setTitle("Combat");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == attackButton){
			double damage = calculatePlayerDamage(player,monster);
			monster.health = (int) (monster.health - damage);
			combatStatus.setText("Player did " + (int)damage + " damage!");
			
			if(monster.health <= 0){
				JOptionPane.showMessageDialog(null, "You won!");
				this.dispose();
			}
			
			else{
			
			monsterTurn(monster);
			}
			
			
		}
		
	}

	private void monsterTurn(Monster monster2) {
		double damage = calculateMonsterDamage(monster, player);
		player.health = (int) (player.health - damage);
		combatStatus.append("\nMonster did " + (int)damage + " damage!");
		
	}

	private double calculateMonsterDamage(Monster monster2, Player player2) {
		double damage = 0;
		
		double monsterDamageModifier = (Math.random() * (monster.attack/2)) + 1;
		double playerDefenseModifier = (Math.random() * (player.toughness/2)) + 1;
		
int plusMinus = (int)Math.floor(Math.random() * 2) +1;
		
		if(plusMinus == 1){
			damage = (monster.attack) + monsterDamageModifier;
		}
		
		else if(plusMinus == 2){
			damage = (monster.attack) + monsterDamageModifier;
		}
		
		plusMinus = (int)Math.floor(Math.random() * 2) +1;
		
		if(plusMinus == 1){
			damage = damage - (player.toughness - playerDefenseModifier);
		}
		
		else if(plusMinus == 2){
			damage = damage - (player.toughness + playerDefenseModifier);
		}
		
		
		return damage;
	}

	private double calculatePlayerDamage(Player player2, Monster monster2) {
		double damage = 0;
		double playerDamageModifier = (Math.random() * (player.strength/2)) + 1;
		double monsterDefenseModifier = (Math.random() * (monster2.defense/2)) + 1;
		
		int plusMinus = (int)Math.floor(Math.random() * 2) +1;
		
		if(plusMinus == 1){
			damage = (player.strength * 10) + playerDamageModifier;
		}
		
		else if(plusMinus == 2){
			damage = (player.strength * 10) + playerDamageModifier;
		}
		
		plusMinus = (int)Math.floor(Math.random() * 2) +1;
		
		if(plusMinus == 1){
			damage = damage - (monster2.defense - monsterDefenseModifier);
		}
		
		else if(plusMinus == 2){
			damage = damage - (monster2.defense + monsterDefenseModifier);
		}
		
		
		return damage;
		// TODO Auto-generated method stub
		
	}

}
