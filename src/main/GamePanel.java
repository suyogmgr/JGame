package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;



public class GamePanel extends JPanel{
	private MouseInputs mouseInputs;
	private float xDelta = 100f, yDelta = 100f;
	private float xDir = 1f, yDir = 1f;
	private int frames = 0;
	private long lastCheck;
	private Color color = new Color(40,50,90);
	private Random random;
	
	
	public GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
	}
	
	public void setRectPos(int x , int y) {
		this.xDelta = x;
		this.yDelta = y;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateRectangle();
		
		g.setColor(color);
		g.fillRect((int)xDelta, (int)yDelta, 200, 50);
		
		frames++;
		
		if(System.currentTimeMillis() - lastCheck >= 1000) {
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS:"+lastCheck);
			frames = 0;
		}
	}

	private void updateRectangle() {
		xDelta += xDir;
		if(xDelta > 400 || xDelta < 0) {
			xDir *= -1;
			color = getRandColor();
		}
			
		yDelta += yDir;
		
		if(yDelta > 400 || yDelta < 0) 
			yDir *= -1;
			color = getRandColor();
	}

	private Color getRandColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		return new Color(r,g,b);
	}	
	
}
