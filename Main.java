import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
	
	private JFrame j;
	private Drawer dr;
	public static void main (String[] args) {
		
		Main a = new Main();
		a.run();	
	}
	
	public void run() {
		setup();
	}
	public void setup() {
		j = new JFrame();
		j.setSize(800, 800);
		j.setVisible(true);
		j.setResizable(false);
		j.setLocation(0, 0);
		j.setLayout(j.getLayout());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBackground(Color.BLACK);
		dr = new Drawer();
		dr.setSize(210,520);
		dr.setBackground(Color.BLACK);
		j.add(dr);
		j.addKeyListener( 
				new KeyListener() {

					@Override
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyCode()==KeyEvent.VK_A) {
							Particle.setAttraction(1);
						}
						if(arg0.getKeyCode()==KeyEvent.VK_S) {
							Particle.setAttraction(0);
						}
						if(arg0.getKeyCode()==KeyEvent.VK_D) {
							Particle.setAttraction(-1);
						}
					}
					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				);
		j.addMouseMotionListener( 
				new MouseMotionListener() {

					@Override
					public void mouseDragged(MouseEvent e) {
					}

					@Override
					public void mouseMoved(MouseEvent e) {
						dr.mouse.setX(e.getX());
						dr.mouse.setY(e.getY());
					}

				}
				);
	}
	
	public void loop() {
	}
}
