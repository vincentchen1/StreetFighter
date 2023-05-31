import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	//add location attributes
	private int x,y;
	private Image img1; 	
	private Image end;
	private AffineTransform ix; 


	public Background() {
		img1 = getImage("/imgs/Cookin.gif"); 
		ix = AffineTransform.getTranslateInstance(x,y);
		init(x,y); 						
		}			
	
	public Background(String fileName) {
	img1 = getImage("/imgs/" +fileName); //load the image for Tree
		ix = AffineTransform.getTranslateInstance(0, 0);
		init(x,y); 	
	}
	

	
	public void changePicture(String newFileName) {
		img1 = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img1, ix, null);
		
		//call update to update the actual picture location
		update();
		
		g2.drawImage(img1,ix,null);

	}
	
	
	private void update() {
		ix.setToTranslation(x, y);
		ix.scale(1.25, 1);
	}
	
	private void init(double a, double b) {
		ix.setToTranslation(a, b);
		ix.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
