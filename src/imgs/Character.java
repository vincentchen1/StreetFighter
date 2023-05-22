package imgs;

public class Character {
	protected int health;
	protected String name;
	
	
	public Character(String name, int health) {
		this.name = name;
		this.health = 100;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
