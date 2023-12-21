package main;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final FPS_SET = 120.0;
	
	public Game() {
		
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
	}
	public void run() {
		
		while(true) {
			
		}
		
	}
}
