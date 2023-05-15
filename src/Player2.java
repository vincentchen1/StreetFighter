import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player2{
	//add location attributes
	private int x,y;
	private Image img; 	
	private AffineTransform tx;
	
	public Player2() {
		img = getImage("/imgs/ryu.gif");
		tx = AffineTransform.getTranslateInstance(x,y);
		x = 100;
		y = 100;
		
		}
	
	


	
	public Player2(String fileName) {
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
		
		
		}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.25, .25);
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
