package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Ultrameganeger.jhava");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();//macht window auf passende grösse für subcomponents(hier: gamepanel)
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}
