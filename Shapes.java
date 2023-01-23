import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Shapes extends JComponent
{
    private int size = 200;
    private ArrayList<Shape> Shapes;

    public Shapes()
    {
        Shapes = new ArrayList<>();
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public void addCircle(double x, double y)
    {
        double dPosX = x - (double)size/2;
        double dPoxY = y - (double)size/2;
        Shapes.add(new Ellipse2D.Double(dPosX, dPoxY, size, size));
        repaint();
        new Thread().start();
    }

    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
    }

}
