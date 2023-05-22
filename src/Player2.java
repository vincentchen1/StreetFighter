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
	//add location attributes
	private int vx,vy;
	private Image img;
	private Image idle; 	
	private Image attack;
	private AffineTransform tx;
	private int delay = 150;
	private boolean t;

	

public Player2(String name, int health, int x, int y) {
	super(name,health, x, y);
		idle = getImage("/imgs/ken.gif");
		attack = getImage("/imgs/kenpunching.png");
		img = idle;
;		tx = AffineTransform.getTranslateInstance(x,y);
//		x = 1000;
//		y = 300;
		init(x,y); 	
		
		}

public void changePicture(String newFileName) {
		img = getImage(newFileName);
	}
	
public void paint(Graphics g) {
	//boundary
	if(x <= -50) {
		x = 0;
	}
	if(x >= 1075) {
		x = 1000;
	}
	
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
//		g.setColor();
		g2.drawRect(x, y, 250, 400);
		x+=vx;
		y+=vy;
		init(x,y);
		if(t) {
			if(delay <= -10) {
				img = idle;
				t = false;
				delay = 150;
			}else {
				delay -= 16;
			}
		}
		
		
		}
	
	
private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.75, .75);
	}

//MOVING

public void left() {
	vx = -20;
}
public void right() {
	vx = 20;
}
public void stop() {
	vx = 0;
}

//ATTACKING
public void attack() {
	img = attack;
	t = true;
	
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

