import javax.swing.ImageIcon;


public class Monster {
	
	int health, defense, attack;
	ImageIcon combatSprite;

	public void setMonsterType(String string) {
		if(string == "zombie"){
			health = 80;
			defense = 10;
			attack = 15;
			combatSprite = new ImageIcon("graphics/sprites/zombie_combat_sprite.png");
		}
		
	}

}
