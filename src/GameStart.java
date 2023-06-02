import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class GameStart {
	private Image start;
	private AffineTransform ix;

	public GameStart() {
		start = getImage("/imgs/Start.PNG");
		ix = AffineTransform.getTranslateInstance(0, 0);
		init(0, 0);
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

	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(start, ix, null);

		// call update to update the actual picture location
		update();

		g2.drawImage(start, ix, null);
		
		

	}

	private void update() {
		ix.setToTranslation(0, 0);
		ix.scale(2.8, 2.33);
	}

	private void init(double a, double b) {
		ix.setToTranslation(a, b);
		ix.scale(2.8, 2.33);
	}

}
