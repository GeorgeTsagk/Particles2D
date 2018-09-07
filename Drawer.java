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
		for(int i = 0; i < 1000; i++) {
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
			g.fillOval(x, y, s, s);
			//g.drawRect(z.x, z.y, z.width, z.height);
			i.update(mouse.getX(), mouse.getY());
			for(Rectangle j : Map) {
				i.interactOnRect(j, g);
			}
		}
	}
	
	public void createMap() {
		Map.add(new Rectangle(100,100,100,100));
		Map.add(new Rectangle(200,100,100,100));
		Map.add(new Rectangle(300,100,100,100));
		Map.add(new Rectangle(400,100,100,100));
		Map.add(new Rectangle(0,100,100,100));
		Map.add(new Rectangle(400,0,100,100));

		Map.add(new Rectangle(110,100,100,100));
		Map.add(new Rectangle(210,100,100,100));
		Map.add(new Rectangle(310,100,100,100));
		Map.add(new Rectangle(410,100,100,100));
		Map.add(new Rectangle(10,100,100,100));
		Map.add(new Rectangle(410,0,100,100));
		
	}
	
	public void drawMap(Graphics g) {
		for(Rectangle x : Map) {
			g.drawRect(x.x, x.y, x.width, x.height);
		}
	}
	
	public void createCross(int x, int y) {
		Map.add(new Rectangle(x+200,y+200,50,50));
		Map.add(new Rectangle(x+150,y+250,50,50));
		Map.add(new Rectangle(x+200,y+250,50,50));
		Map.add(new Rectangle(x+250,y+250,50,50));
		Map.add(new Rectangle(x+200,y+300,50,50));
		
		Map.add(new Rectangle(x+200,y+225,50,50));
		Map.add(new Rectangle(x+175,y+250,50,50));
		Map.add(new Rectangle(x+225,y+250,50,50));
		Map.add(new Rectangle(x+200,y+275,50,50));
	}
}