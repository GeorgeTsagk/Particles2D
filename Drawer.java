import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Drawer extends JPanel{
	public MousePointer mouse;
	private ArrayList<Particle> list;
	private Random rand;
	public ArrayList<Rectangle>Map;
	public Drawer() {
		rand = new Random();
		mouse = new MousePointer();
		list = new ArrayList<Particle>();
		Map = new ArrayList<Rectangle>();
		for(int i = 0; i < 1; i++) {
			list.add(new Particle(rand.nextInt(100)+300, rand.nextInt(100)+300, rand.nextInt(2)+4, true));
		}
		createMap();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		super.setSize(800,800);
		g.setColor(Color.WHITE);
		g.drawOval(mouse.getX()-3, mouse.getY()-3, 6, 6);
		g.drawString(mouse.getX() + "-" + mouse.getY(), 0, 0);
		drawMap(g);
		drawParticles(g);
		try {
			Thread.sleep(8);
		}catch(Exception e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	
	public void drawParticles(Graphics g) {
		g.setColor(Color.CYAN);
		for(Particle i : list) {
			
			g.setColor(i.getColor());
			int x = i.getX();
			int y = i.getY();
			int s = i.getSize();
			Rectangle z = i.interactor;
			g.drawRect(z.x, z.y, z.width, z.height);
			i.update(mouse.getX(), mouse.getY());
			for(Rectangle j : Map) {
				i.interactOnRect(j, g);
			}
		}
	}
	
	public void createMap() {
		Map.add(new Rectangle(200,200,50,50));
		Map.add(new Rectangle(150,250,50,50));
		Map.add(new Rectangle(200,250,50,50));
		Map.add(new Rectangle(250,250,50,50));
		Map.add(new Rectangle(200,300,50,50));
	}
	
	public void drawMap(Graphics g) {
		for(Rectangle x : Map) {
			g.drawRect(x.x, x.y, x.width, x.height);
		}
	}
}