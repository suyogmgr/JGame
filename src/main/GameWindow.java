package main;
import javax.swing.JFrame;

public class GameWindow {
	private JFrame jFrame;
	public GameWindow(){
		jFrame = new JFrame();
		
		jFrame.setTitle("New Game");
		jFrame.setSize(400,400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
}
