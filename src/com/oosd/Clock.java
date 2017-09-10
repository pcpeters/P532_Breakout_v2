package com.oosd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Clock  extends GameObjects implements Observer 
{
    private static final int MILLISEC_TO_SEC = 1000;
    private int time;
    
    /*
     * Function Name: Clock
     * Parameters In: Coordinates, size and color of clock
     * Parameters Out: None
     * Description: Constructor to initialize the clock object
     */
    public Clock(int x, int y, int width, int height, Color color) 
    {
        super(x, y, width, height, color);
        time = 0;
    }
    
    /*
     * Function Name: draw
     * Parameters In: Graphics
     * Parameters Out: None
     * Description: Paints the clock on the canvas.
     */
    @Override
    public void draw(Graphics g) 
    {
        g.setColor(color);
        
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        g.setFont(newFont);
        
        //Calculate minutes and seconds
        int mm = time / MILLISEC_TO_SEC / 60 % 60;
        int ss = time / MILLISEC_TO_SEC % 60;
        
        g.drawString(String.format("%02d:%02d", mm, ss), x, y);
        g.setFont(currentFont);
    }

    /*
     * Function Name: update
     * Parameters In: timeStep
     * Parameters Out: None
     * Description: Logic to update the time.
     */
    @Override
    public void update(int timeStep) 
    {
        time = (time + timeStep) % (3600 * MILLISEC_TO_SEC);
    }
}