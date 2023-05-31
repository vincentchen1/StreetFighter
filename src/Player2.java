import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player2 extends Character {
	// add location attributes
	private Image img;
	private Image idle;
	private Image attack;
	private AffineTransform tx;
	private int delay = 150;
	private boolean transition;

	public Player2(String name, int health, int x, int y, int width) {
		super(name, health, x, y, width, 1);
		idle = getImage("/imgs/ken.gif");
		attack = getImage("/imgs/kenpunching.png");
		img = idle;
		tx = AffineTransform.getTranslateInstance(x, y);

		init(x, y);
	}
	

	
	public void reset() {
		health = 100;
		x = 1200;
		y = 300;
		
	}
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
	}

	public void paint(Graphics g) {
		// boundary
		if (x <= -50) {
			//left wall
				x = 0;
			}
			
			//right wall
			if (x >= 1075) {
				x = 1000;
			}
			
			if (y >= 300) {
				y = 300;
				vy = 0;
				gravity = 0;
			}
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
//		g.setColor();
		//g2.drawRect(x + 20, y, 200, 400);
		x += vx;
		y += vy;
		
		vy += gravity;
		init(x, y);
		if (transition) {
			if (delay <= -10) {
				img = idle;
				transition = false;
				delay = 150;
			     isAttacking = false;
			     justAttacked = false;
			} else {
				delay -= 16;
			}
		}

	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.75, .75);
	}

//ATTACKING
	public void attack() {
		img = attack;
		transition = true;
		isAttacking = true;
	    justAttacked = true;


	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player2.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
