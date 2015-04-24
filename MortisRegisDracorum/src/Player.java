import javax.swing.ImageIcon;


public class Player {
	
	int level = 1;
	int health, mana, fury, energy, toughness, dexterity, intelligence, strength;
	int currentTile;
	String player_class;
	ImageIcon sprite = new ImageIcon("graphics/sprites/warrior_down.png");
	
	
	public void setClass(String string) {
		player_class = string;
		
		if(string == "Warrior"){
			strength = 4;
			toughness = 3;
			dexterity = 2;
			intelligence = 1;
			fury = 0;
		}
		
		health = 100 + (dexterity * 10);
		
		
		
	}
	

}
