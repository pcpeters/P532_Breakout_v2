import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartOrRestart extends KeyAdapter {
/*	It starts the game when s is clicked once
 *  It restarts the game when s is clicked twice in 300 ms
 */
	public static boolean SORclicked = true;
	public static boolean beginMove = true;
	private Clock clock;
	private Ball ball;
	private Brick brick;
	private Paddle paddle;
	
	private static int doublePressSpeed = 300;
	private static long timeKeyDown = 0;
	private static int lastKeyPressedCode;
	public static boolean SORisDoublePressed(KeyEvent ke) {
		if ((ke.getWhen() - timeKeyDown) < doublePressSpeed) {
			return true;
		} else {
			timeKeyDown = ke.getWhen();
		}
		lastKeyPressedCode = ke.getKeyCode();
		return false;
	}
	
	
	private void start() {
		SORclicked = false;
		beginMove = false;
	}
	
	private void stop() {
		SORclicked = true;
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		if (key == KeyEvent.VK_S) {
				start(); //Plays the game
				
		} if(key == KeyEvent.VK_S &&SORisDoublePressed(ke) && lastKeyPressedCode == ke.getKeyCode()) {
				//reset to initial state if double clicked
				stop();
				resetAll();
				start();
			}
		}
	
	private void resetAll() {
		clock.reset();
		brick.reset();
		BreakoutUI.makeBricks();
		ball.reset();
		paddle.reset();
	}
}