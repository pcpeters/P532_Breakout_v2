import javax.swing.JFrame;

public class Breakout
{
	private static JFrame frame;
	private static BreakoutUI ui;
	
	public static void main(String[] ar)
	{	

		frame = new JFrame("Breakout: The Beginnings");
		frame.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		ui = new BreakoutUI(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		frame.getContentPane().add(ui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
	}
}
