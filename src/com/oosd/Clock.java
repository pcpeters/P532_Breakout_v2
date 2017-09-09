import java.awt.Color;
import java.awt.Graphics;

public class Clock extends GameObject implements Observer {

	private int time;
	
	public Clock(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		time = 0;
	}

	@Override
	public void update(int signal) {
		time = (time + signal) % (60*60*1000);
		
	}	
	
	public void draw(Graphics g) {
		//System.out.print("\nTime: "+time);
		g.setColor(color);
		
		int minute = time / 1000 / 60 % 60;
		int second = time / 1000 % 60;
		
		//System.out.print(" Min: "+minute+" Sec: "+second);
		
		g.drawString(String.format("Time : %02d:%02d", minute, second), x, y);
	
	}
	
	//reset clock back to 0
    public void reset() {
    	this.time = 0;
    }
}
