import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player1 {
	//add location attributes
	private int x,y;
	private int vx, vy;
	private Image img; 	
	private AffineTransform tx;
	

	
	public Player1(){
		img = getImage("/imgs/ryu.gif"); 
		tx = AffineTransform.getTranslateInstance(x,y);
		x = 0;
		y = 300;
		init(x,y);

		}	
	
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		x+=vx;
		y+=vy;
		init(x,y); //call this if you're updating x,y
		}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.75,.75);
	}
	
	
	//MOVING

	public void left() {
		vx = -20;
	}
	public void right() {
		vx = 20;
	}
	public void stop() {
		vx=0;
	}
	
	public void boundary( ) {
		if (x > 0) {
			x = -x;
		}
	}


	private Image getImage(String path) {
			Image tempImage = null;
				try {
						URL imageURL = Player1.class.getResource(path);
						tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
				} catch (Exception e) {
					e.printStackTrace();
		}
				return tempImage;
	}
	
}




