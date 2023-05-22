import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Background home= new Background();
	Player1 a = new Player1("Ryu", 100, 0, 300);
	Player2 b = new Player2("Ken", 100, 1000, 300);
	
	int Playerhealth = a.getHealth();
	int Player2health = b.getHealth();

	
	public void paint(Graphics g) {
		g.fillRect(0,0,800,800);
		super.paintComponent(g);
		home.paint(g);
		a.paint(g);
		a.collision(b.getX(),b.getY());
		b.paint(g);
		b.collision(a.getX(), a.getY());
		
		Font plainfont = new Font("Courier New", Font.PLAIN,90);
		g.setFont(plainfont);
		g.setColor(Color.red);
		g.drawString(" " + b.getHealth(),10, 100);
		
		Font player1font = new Font("Courier New", Font.PLAIN,90);
		g.setFont(player1font);
		g.setColor(Color.blue);
		g.drawString(" " + a.getHealth(), 1000, 100);
		
	}

		
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Punch Punch");
		f.setSize(new Dimension(1280, 720));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
			
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode());
		
		//player 1
		if(arg0.getKeyCode()==65) {
			a.left();
		}
		if(arg0.getKeyCode()==68) {
			a.right();
		}
		
		
		//attack call
		if(arg0.getKeyCode() == 70) {
			 a.attack();
		}
		
		
		
		//player 2
		if(arg0.getKeyCode()==37) {
			b.left();
		}
		if(arg0.getKeyCode()==39) {
			b.right();
		}
		
		
		//attack call
		if(arg0.getKeyCode() == 17) {
			 b.attack();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		//player 1
		if(arg0.getKeyCode()==65) {
			a.stop();
		}
		if(arg0.getKeyCode()==68) {
			a.stop();
		}

		
		//player 2
		if(arg0.getKeyCode()==37) {
			b.stop();
		}
		if(arg0.getKeyCode()==39) {
			b.stop();
		}
		
	
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void reset() {
		
	}

}
