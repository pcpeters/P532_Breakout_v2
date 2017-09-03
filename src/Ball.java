import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject implements Observer{

	private int xDir = 1;
	private int yDir = -1;
	
	public Ball(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, width, height);
		
	}
	
	// Resets the ball to original position at center of screen
    public void reset() {
        x = Constants.BALL_X_START;
        y = Constants.BALL_Y_START;
        xDir = 1;
        yDir = -1;
    }
    
	//Getters and setters
	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}	
	
	//Updates the movement of ball
	@Override
	public void update(int signal){
		x += xDir;
		y += yDir;
		//System.out.println("x:" + x + "y:" + y);
	}	
}
