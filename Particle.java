import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Particle {
	private float x;
	private float y;
	private float xvel;
	private float yvel;
	private float xacc;
	private float yacc;
	private int size;
	public Rectangle interactor;
	private Random rand;
	private Color myColor;
	private boolean alive;
	private static int isAttracted;
	public Particle(int x, int y,int size, boolean life) {
		interactor = new Rectangle(x, y, size+3, size+3);
		this.size = size;
		rand = new Random();
		this.x = x;
		this.y = y;
		this.xvel = 0;
		this.yvel = 0;
		this.xacc = 0;
		this.yacc = 0;
		alive = life;
		isAttracted = 0;
		myColor = new Color((int)(y*3)%255, (int)x%255, 255, 255);
	}
	
	public void update(int j, int k) {
			if(alive) {
				interactor.x = (int)x;
				interactor.y = (int)y;
				int d = Functions.distance((int)x, (int)y, j, k);
				x += 0.5 * xvel;
				y += 0.5 * yvel;
				if(isAttracted==1) {
					xvel += rand.nextInt(3)*(j-x)/(d+1);
					yvel += rand.nextInt(3)*(k-y)/(d+1);
				}
				if(isAttracted==-1) {
					xvel -= rand.nextInt(3)*(j-x)/(d+1);
					yvel -= rand.nextInt(3)*(k-y)/(d+1);
				}
				xvel /= 1.02;
				yvel /= 1.02;
				if(xvel > 15) xvel = 15;
				if(xvel < -15) xvel = -15;
				if(yvel > 15) yvel = 15;
				if(yvel < -15) yvel = -15;
				respectBounds();
			}
			
	}
	public void respectBounds() {
		if(x < 10) {
			xvel = -xvel/2;
			x = 11;
		}
		if(x > 780) {
			xvel = -xvel/2;
			x = 780;
		}
		if(y < 10) {
			yvel = -yvel/2;
			y = 11;
		}
		if(y > 760) {
			yvel = -yvel/2;
			y = 760;
		}
	}
	
	public void interactOnRect(Rectangle a, Graphics g) {
		//Rectangle a = new Rectangle(b.x -2, b.y -2, b.width +4, b.height +4);
		Rectangle judge = interactor.intersection(a);
		if(interactor.intersects(a)) {
			if(judge.height > judge.width) {
				if(interactor.x > a.getCenterX()){
					xvel = -xvel/2;
					x = a.x + a.width + judge.width/100;
				}
				if(interactor.x < a.getCenterX()){
					xvel = -xvel/2;
					x = a.x - interactor.width - judge.width/100;
				}
			}else if(judge.height < judge.width){
				if(interactor.y > a.getCenterY()){
					yvel = -yvel/2;
					y = a.y + a.height + judge.height/100;
				}
				if(interactor.y < a.getCenterY()){
					yvel = -yvel/2;
					y = a.y - interactor.height - judge.height/100;
				}
			}else if(judge.height == judge.width) {
				x=-xvel/2;
				y=-yvel/2;
				if(interactor.x < a.getCenterX())
					if(interactor.y < a.getCenterY()) {
						x = a.x - judge.width/100 - 1;
						y = a.y - judge.height/100 - 1;
					}
					else if(interactor.y > a.getCenterY()) {
						x = a.x - judge.width/100 - 1;
						y = a.y + a.height + judge.height/100 + 1;
					}
				if(interactor.x > a.getCenterX())
					if(interactor.y < a.getCenterY()) {
						x = a.x + a.width + judge.width/100 + 1;
						y = a.y - judge.height/100 - 1;
					}
					else if(interactor.y > a.getCenterY()) {
						x = a.x + a.width + judge.width/100 + 1;
						y = a.y + a.height + judge.height/100 + 1;
					}
				
			}
		}
		g.drawRect(judge.x, judge.y, judge.width, judge.height);
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public int getXvel() {
		return (int)xvel;
	}
	
	public int getYvel() {
		return (int)yvel;
	}
	
	public int getXacc() {
		return (int)xacc;
	}
	
	public int getYacc() {
		return (int)yacc;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public static void setAttraction(int a) {
		isAttracted = a;
	}
	
	public Color getColor() {
		return this.myColor;
	}
}
