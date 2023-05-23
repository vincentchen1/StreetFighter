

public class Character {
	protected int health;
	protected String name;
	protected int x, y;
	
	
	public Character(String name, int health, int x, int y) {
		this.name = name;
		this.health = 100;
		this.x = x;
		this.y = y;
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
	


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	} 
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public void colli	sion(int otherPlayerX,int otherPlayerY) {
		
	}

}
