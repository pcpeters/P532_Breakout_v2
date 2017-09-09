import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject{
	
	public Paddle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
	
	public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
	
	public void reset() {
        x = Constants.PADDLE_X_START;
        y = Constants.PADDLE_Y_START;
    }
	
	public boolean hitPaddle(int ballX, int ballY) {
        if ((ballX >= x) && (ballX <= x + width)
                && ((ballY >= y) && (ballY <= y + height))) {
            return true;
        }
        return false;
    }
}
