package main;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	
	public Game() {
		
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void run() {
		
		double timeFrame = 1000000000.00 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		while(true) {
			
			now = System.nanoTime();
			if(now - lastFrame >= timeFrame) {
				gamePanel.repaint();
				lastFrame = now;
			}
		}
		
	}
}
