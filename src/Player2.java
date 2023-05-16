import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player2 {
	//add location attributes
	private int x,y;
	private int vx,vy;
	private Image img; 	
	private Image attackImg;
	private AffineTransform tx;
	private boolean moving;
	

public Player2() {
		img = getImage("/imgs/ken.gif");
		attackImg = getImage("/imgs/kenpunching.png");
;		tx = AffineTransform.getTranslateInstance(x,y);
		x = 950;
		y = 300;
		init(x,y); 	
		
		}

public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		x+=vx;
		y+=vy;
		init(x,y);
		
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
	Graphics2D g2 = null;
	g2.drawImage(attackImg, tx, null);
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
