
public class Character {
	protected int health;
	protected String name;
	protected int x;
	protected int y;
	protected int vx, vy;
	protected int width;
	protected int side;
	protected boolean isAttacking;
	protected boolean justAttacked;
	protected boolean isJumping;
	
	
   
	public void setVy(int vy) {
	    this.vy = vy;
	}

	public int getVy() {
	    return vy;
	}
	
	public boolean isJumping() {
	    return isJumping;
	}

	public void setJumping(boolean isJumping) {
	    this.isJumping = isJumping;
	}

	public void jump() {
	    if (!isJumping) { // Jump only if the character is not already jumping
	        vy = -20; // Adjust this value as needed
	        isJumping = true;
	    }
	}
	public boolean isAttacking() {
	    return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
	    this.isAttacking = isAttacking;
	}

	public boolean justAttacked() {
	    return justAttacked;
	}

	public void setJustAttacked(boolean justAttacked) {
	    this.justAttacked = justAttacked;
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Character(String name, int health, int x, int y, int width, int side) {
		this.name = name;
		this.health = 100;
		this.x = x;
		this.y = y;
		this.width = width;
		this.side = side;
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

	// MOVING
	public void left() {
		vx = -20;
	}

	public void right() {
		vx = 20;
	}

	public void stop() {
		vx = 0;
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


	public void setName(String name) {
		this.name = name;
	}

	public void collision(Character otherPlayer) {
		System.out.println("check collision");
		if (Math.abs(this.getX() - otherPlayer.getX()) < this.getWidth()) {
			if (this.getX() > otherPlayer.getX()) {
				this.setX(otherPlayer.getX() + this.getWidth());
			} else {
				this.setX(otherPlayer.getX() - this.getWidth());
			}

			if (otherPlayer.isAttacking() && otherPlayer.justAttacked()) {
				// Decrease health of current player
				this.setHealth(this.getHealth() - 10);
				otherPlayer.setJustAttacked(false); // so that the health doesn't decrease again for the same attack
			}
		}
	}
}
