package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{ //macht, dass GamePanel auch alle funktionen von JPanel hat
	//Screen settings:
	final int originalTileSize = 32; //32x32Tile
	final int scale = 2; //skalieren der figur um nicht winzig zu sein
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	//-ende screen settings
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);//pixel malen passiert offscreen dadurch bessere performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
		while (gameThread != null) {
			
			//UPDATE GAMESTATE:
			
			update();
			
			//DRAW GAMESTATE:
			
			repaint();
		}
	}
	
	public void update() {
		
	}
	
	public void repaint() {
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(100, 100, tileSize, tileSize);
		g2.dispose(); //saves memory
	}
}
