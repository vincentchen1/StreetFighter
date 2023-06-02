import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class GameOver {
	private Image end;
	private AffineTransform ix;

	public GameOver() {
		end = getImage("/imgs/GAMEOVER.gif");
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
		g2.drawImage(end, ix, null);

		// call update to update the actual picture location
		update();
		g.setColor(Color.red);
		Font player1font = new Font("impact", Font.PLAIN,90);
		g.setFont(player1font);

		g.drawString(" Click R to Restart", 100 , 100);
		g2.drawImage(end, ix, null);
		g.drawString(" Click R to Restart", 100 , 80);
		

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
