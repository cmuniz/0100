import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed;               
    private int xSpeed;

    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    int groundPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        diameter = ballDiameter;
        color = ballColor;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        ySpeed = 1;
        xSpeed = 1;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
        /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    } 
    
        public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position

        yPosition += ySpeed;
        xPosition += ySpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter)) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed; 
        }

        // draw again at new position
        draw();
    }   
    
        /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }

}
