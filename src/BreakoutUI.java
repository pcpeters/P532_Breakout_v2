import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class BreakoutUI extends JPanel implements Subject, Runnable {
	
	private List<Observer> observers;

	private Ball ball;
	private Paddle paddle;
	private Clock clock;
	private Brick[][] brick = new Brick[Constants.BRICK_COLUMNS][Constants.BRICK_ROWS];
	
	private Thread game;
	
	private volatile boolean isPaused = true;
	private boolean gameOver = false;
	
	//Constructor
	public BreakoutUI(int width, int height ){
		
		super.setSize(width, height);		
		addKeyListener(new UIListener());
		setFocusable(true);		
		setBackground(Color.WHITE);
		
		paddle = new Paddle(Constants.PADDLE_X_START, Constants.PADDLE_Y_START, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Color.BLUE);		
        ball = new Ball(Constants.BALL_X_START, Constants.BALL_Y_START, Constants.BALL_WIDTH, Constants.BALL_HEIGHT, Color.GREEN);
        clock = new Clock(getWidth() - 100, getHeight() - 30, Constants.BALL_WIDTH, Constants.BALL_HEIGHT, Color.RED);
        makeBricks();        
        
        addKeyListener(null);
        
        observers = new ArrayList<Observer>();
        register(ball);
        register(clock);
        
        game = new Thread(this);
        game.start();
	}


	// Fills the array of bricks
    private void makeBricks() {
        for (int i = 0; i < Constants.BRICK_COLUMNS; i++) {
            for (int j = 0; j < Constants.BRICK_ROWS; j++) {
                brick[i][j] = new Brick((i * Constants.BRICK_WIDTH),
                        ((j * Constants.BRICK_HEIGHT) + (Constants.BRICK_HEIGHT / 2)),
                        Constants.BRICK_WIDTH - 5, Constants.BRICK_HEIGHT - 5, Color.YELLOW);
            }
        }
    }
	
	//Start thread
    private void start() {
        isPaused = false;
    }

    //Stop thread
    private void stop() {
        isPaused = true;
    }

    
	@Override
	public void run() {
		
		while (true) {
			
			while(!isPaused){
				
				int x = ball.getX();
	            int y = ball.getY();

	            checkWall(x, y);
	            //checkIfOut(y);
	            checkPaddle(x, y);
	            brickCollisionCheck(x, y);
				notifyObserver();
				repaint();
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}			
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paddle.draw(g);
		ball.draw(g);
		clock.draw(g);
		
		for (int i = 0; i < Constants.BRICK_COLUMNS; i++) {
            for (int j = 0; j < Constants.BRICK_ROWS; j++) {
                brick[i][j].draw(g);
            }
        }
		
		if(gameOver){
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
			g.drawString("Game Over!", getWidth() /3, getHeight()/2);
			
		}
	}

	private void checkWall(int x, int y) {
		 
		 if(getWidth() > 0){
			//Right wall		 
			 if (x >= getWidth() - ball.getWidth()) {	
		         ball.setxDir(-1);
			 }
			 
			 //Left wall
			 if (x <= 0) {
		         ball.setxDir(1);
		     }
			 
			 //Top
		     if (y <= 0) {
		    	 ball.setyDir(1);
		     }
		         
		     //Bottom
		     if (y >= getHeight()) {
		    	 //ball.setyDir(-1);
		    	 gameOver=true;
		    	 stop();
		     }			 
		 }		 
	 }
	 
	 public void checkPaddle(int x, int y){		
		 
		 //Checking paddle collision
		 if((x >= paddle.getX()) && (x <= (paddle.getX() + paddle.getWidth()))
				 && ((y + ball.getHeight() >= paddle.getY())) && (y <= (paddle.getY() + paddle.getHeight()))){
			 
			 ball.setyDir(-1);
		 }
		 
		 //To ensure paddle is bound by the frame
		 if(paddle.getX() <=0) {
			 paddle.setX(0);
		 }
		 
		 if (paddle.getX() + paddle.getWidth() >= getWidth()) {
	         paddle.setX(getWidth() - paddle.getWidth());
	     }
	 }
	 
	 private void brickCollisionCheck(int x, int y) {
		 for (int i=0; i<Constants.BRICK_COLUMNS;i++) {
			 for (int j=0; j<Constants.BRICK_ROWS; j++) {
				 
				 if (brick[i][j].bottomCollision(x, y)) {
					 ball.setyDir(-ball.getyDir());
				 }
				 if (brick[i][j].leftCollision(x, y)) {
					 ball.setxDir(-ball.getxDir());
				 }
				 if (brick[i][j].rightCollision(x, y)) {
					 ball.setxDir(-ball.getxDir());
				 }
				 if (brick[i][j].topCollision(x, y)) {
					 ball.setyDir(-ball.getyDir());
				 }
			 }
		 }
	 }
	 

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	

	@Override
	public void notifyObserver() {
		for (Observer observer: observers) {
			observer.update(5);
		}
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		
	}
	
	private class UIListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent ke) {
			
			int key = ke.getKeyCode();
			
			//To start or pause the game
			if (key == KeyEvent.VK_SPACE) {
				if(!isPaused){
					stop();
				}
				else{
					start();
				}
			}

			if (key == KeyEvent.VK_LEFT) {
				paddle.setX(paddle.getX() - 50);
			}
			
			if (key == KeyEvent.VK_RIGHT) {
				paddle.setX(paddle.getX() + 50);
			}
		}
	}
	
}
