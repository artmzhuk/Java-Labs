import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {
    private static int radiusA = 100;
    private static int radiusB = 100;
    private static int angle = 0;


    public void setRadiusA(int r) {
        radiusA = r;
        repaint();
    }

    public void setRadiusB(int r) {
        radiusB = r;
        repaint();
    }
    public void setAngle(int r) {
        angle = r;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.translate(150, 150);
        g.drawLine(-300, 0,200,0);
        g.drawLine(0, -300,0,200);
        g2d.setColor(Color.RED);
        g2d.rotate(Math.toRadians(angle));
        g2d.drawOval(-radiusA/2, -radiusB/2, radiusA, radiusB);
    }
}
