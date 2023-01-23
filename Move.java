import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Move {

    static JLabel label;
    protected static Shapes shapes;

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    Move(){
        shapes = new Shapes();

        label = new JLabel();
        label.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        label.setBackground(Color.lightGray);
        label.setBounds(10,10,1000,500);
        label.add(shapes, BorderLayout.CENTER);
        label.setVisible(true);

        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        shapes.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        shapes.getActionMap().put("upAction", upAction);
        shapes.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        shapes.getActionMap().put("downAction", downAction);
        shapes.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        shapes.getActionMap().put("leftAction", leftAction);
        shapes.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        shapes.getActionMap().put("rightAction", rightAction);
    }

    public class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY()-10);
        }
    }
    public class DownAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY()+10);
        }
    }
    public class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()-10, label.getY());
        }
    }
    public class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()+10, label.getY());
        }
    }
}