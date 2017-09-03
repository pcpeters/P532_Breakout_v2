import java.awt.Color;
import java.awt.Graphics;

public class Brick extends GameObject{

	private boolean destroyed;
	
	//Constructor
	public Brick(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color);
		setDestroyed(false);
	}
	
	public void draw(Graphics g) {
		if (!destroyed) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void brickCollision() {
		setDestroyed(true);
	}
	
	public boolean bottomCollision(int xBall, int yBall) {
		if ((xBall >= x) && (xBall <= x + width) && (yBall == y + height) && (destroyed == false)) {
			brickCollision();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean topCollision(int xBall, int yBall) {
		if ((xBall >= x) && (xBall <= x + width) && (yBall == y) && (destroyed == false)) {
			brickCollision();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean leftCollision(int xBall, int yBall) {
		if ((yBall >= y) && (yBall <= y + height) && (xBall == x) && (destroyed == false)) {
				brickCollision();
				return true;
		}
		else {
			return false;
		}
	}
	
	public boolean rightCollision(int xBall, int yBall) {
		if ((yBall >= y) && (yBall <= y + height) && (xBall == x + width) && (destroyed == false)) {
				brickCollision();
				return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
}
