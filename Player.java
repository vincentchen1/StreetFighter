mport java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck{
	//add location attributes
	private int x,y;
	private int vx,vy;
	private Image img; 	
	private AffineTransform tx;
	
	public Duck() {
		img = getImage("/imgs/bomba.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x,y);
		x = 100;
		y = 200;
		init(x,y); 					
		vx = (int) (Math.random() *25) - 8;
		vy = (int) (Math.random()* 18) - 8;	
		
		while(vx >= -4 && vx <= 4){
		vx = (int)Math.random()*16 - 8;	
		}
		
		while(vy >= -4 && vy <= 4) {
		vy = (int)Math.random() *16 - 8;
		
		}
	
	}

	

	
	
	public Duck(String fileName) {
	img = getImage("/imgs/" +fileName); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(0, 0);
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
		
		x = x + vx;
		y = y + vy;
		
		if (x > 575|| x < -70) {
			vx = -vx;

		}
		if(y > 320 || y < 0) {
			if(vy != 10) {
				vy = -vy;
			}

	}	
		
		
		
		update();
		g.setColor(Color.black);
		//g.drawRect(x,y,195,150);
		
		}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(.66, .64);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
			Image tempImage = null;
				try {
						URL imageURL = Duck.class.getResource(path);
						tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
				} catch (Exception e) {
					e.printStackTrace();
		}
				return tempImage;
	}
	
	
	public boolean hit(MouseEvent mouse) {
	Rectangle m = new Rectangle(mouse.getX(),mouse.getY(),30,30);
	
	//duck hit box
	Rectangle d = new Rectangle(x,y,160,120);
	
	//check if the two hit boxes overlap
	if (m.intersects(d)){
		//drops from the sky
		img = getImage("/imgs/pixil-frame-5.png");
		System.out.println("HIT");
		vx = 0;
		vy = 10;
		
		return true;
	}
	return false;
}

		

}
