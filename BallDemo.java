import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        Random rnd = new Random();
        // crate and show the balls
        ArrayList<BouncingBall> balls = new ArrayList<>();
        for(int i = 0; i < numBalls; i++){
            Color color = new Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
            balls.add(new BouncingBall((rnd.nextInt(250)+50), rnd.nextInt(400), rnd.nextInt(20)+5, color, ground, myCanvas));
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < balls.size(); i++){
                balls.get(i).move();

                // stop once ball has travelled a certain distance on x axis
                if(balls.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }

    public void boxBounce(int numBalls){
        int ground = 400;   // position of the ground line
        int techo = 100;
        int paredDerecha = 550;
        int paredIzquierda = 50;

        myCanvas.setVisible(true);

        myCanvas.drawLine(paredIzquierda, ground, paredDerecha, ground);        
        myCanvas.drawLine(paredIzquierda, techo, paredDerecha, techo);
        myCanvas.drawLine(paredIzquierda, techo, paredIzquierda, ground);
        myCanvas.drawLine(paredDerecha, ground, paredDerecha, techo);

        Random rnd = new Random();

        ArrayList<BoxBall> balls = new ArrayList<>();
        for(int i = 0; i < numBalls; i++){
            Color color = new Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
            balls.add(new BoxBall((rnd.nextInt(450)+75), (rnd.nextInt(250)+125), rnd.nextInt(40)+10,
                    color, rnd.nextBoolean(), rnd.nextBoolean(), ground, techo, paredDerecha, paredIzquierda, myCanvas));
            balls.get(i).draw();
        }
        
                
        while(true) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < balls.size(); i++){
                balls.get(i).move();
            }
        }
    }
}
